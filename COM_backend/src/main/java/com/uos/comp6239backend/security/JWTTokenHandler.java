package com.uos.comp6239backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @title: JWTTokenHandler
 * @Author Hym
 * @Date: 2024-03-17 23:00
 * @Description:
 * @Version 1.0
 */
@Component
@ConditionalOnClass(RedisTemplate.class)
public class JWTTokenHandler {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Value("${spring.security.jwt.token-prefix}")
    private String tokenPrefix;

    public void save(String token, DefaultUser user) {
        redisTemplate.opsForValue().set(getKey(user), token, 3, TimeUnit.DAYS);
    }

    public boolean reload(String token, DefaultUser user) {
        Object key;
        Boolean f = null;
        boolean ff = (key = redisTemplate.opsForValue().get(getKey(user))) != null
                && token.equals(key)
                && (f = redisTemplate.expire(getKey(user), 3, TimeUnit.DAYS)) != null && f;
        return ff;
    }

    private String getKey(DefaultUser user) {
        return tokenPrefix + "_" + user.getUserId();
    }
}
