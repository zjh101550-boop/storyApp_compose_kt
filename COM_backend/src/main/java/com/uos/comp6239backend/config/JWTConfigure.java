package com.uos.comp6239backend.config;

import com.uos.comp6239backend.security.JWTEncrypt;
import com.uos.comp6239backend.security.JWTTokenHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title: JWTConfigure
 * @Author Hym
 * @Date: 2024-03-18 6:56
 * @Description:
 * @Version 1.0
 */
@Configuration
public class JWTConfigure {

    @Autowired
    private JWTConfigurationProperties jwtConfigurationProperties;

    @Bean
    public JWTEncrypt jwtEncrypt(JWTTokenHandler jwtTokenHandler){
        JWTEncrypt encrypt = new JWTEncrypt();
        encrypt.setIssuer(jwtConfigurationProperties.getIssuer());
        encrypt.setSecretKey(jwtConfigurationProperties.getSecretKey());
        encrypt.setJwtTokenHandler(jwtTokenHandler);
        return encrypt;
    }
}
