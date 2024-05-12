package com.uos.comp6239backend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @title: JWTEncrypt
 * @Author Hym
 * @Date: 2024-03-18 4:59
 * @Description:
 * @Version 1.0
 */
public class JWTEncrypt {
    private String secretKey;
    private String issuer;
    private JWTTokenHandler jwtTokenHandler;

    //    该方法用于生成一个包含用户信息和权限的JWT令牌
    public String encode(DefaultUser user) {
        // 从DefaultUser对象中获取用户的权限（authorities），并将它们转换成字符串数组urls。
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        String[] urls = new String[authorities.size()];
        int i = 0;
        for (GrantedAuthority authority : authorities) {
            urls[i++] = authority.getAuthority();
        }
        //JWT加密
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        String token = JWT.create()
                .withIssuer(issuer)
                .withSubject("userInfo")
                .withClaim("username", user.getUsername())
                .withClaim("userId", user.getUserId())
                .withClaim("userType", user.getUserType())
                .withArrayClaim("authorities", urls)
                .sign(algorithm);
        // 使用jwtTokenHandler的save方法将生成的令牌和用户信息保存到Redis
        jwtTokenHandler.save(token, user);
        return token;
    }

    //    该方法用于解析和验证一个给定的JWT令牌字符串
    public DefaultUser decode(String encodedStr, FindPasswordByUserId findPasswordByUserId) {

        //使用HMAC256算法和secretKey创建一个JWT验证器verifier。
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        // 调用verifier.verify(encodedStr)验证并解码JWT令牌，得到一个DecodedJWT对象。从解码后的JWT中提取用户信息和权限声明。
        DecodedJWT decodedJWT = verifier.verify(encodedStr);
        String[] authorities = decodedJWT.getClaim("authorities").asArray(String.class);
        String username = decodedJWT.getClaim("username").as(String.class);
        Integer userId = decodedJWT.getClaim("userId").as(Integer.class);
        Integer userType = decodedJWT.getClaim("userType").as(Integer.class);

        List<SimpleGrantedAuthority> authorityList = Arrays.stream(authorities).map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        //根据解码出来的用户信息，创建一个新的DefaultUser对象，并从findPasswordByUserId回调中获取用户的密码。
        DefaultUser user = new DefaultUser(userId, userType, username, findPasswordByUserId.getPassword(userId), authorityList);

        if (!jwtTokenHandler.reload(encodedStr, user)) {
            throw new ReloadTokenFailException("更新token失败");
        }
        return user;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public JWTTokenHandler getJwtTokenHandler() {
        return jwtTokenHandler;
    }

    public void setJwtTokenHandler(JWTTokenHandler jwtTokenHandler) {
        this.jwtTokenHandler = jwtTokenHandler;
    }
}
