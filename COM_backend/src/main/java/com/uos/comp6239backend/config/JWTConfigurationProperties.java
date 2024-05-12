package com.uos.comp6239backend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @title: JWTConfigurationProperties
 * @Author Hym
 * @Date: 2024-03-18 7:03
 * @Description:
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "spring.security.jwt")
public class JWTConfigurationProperties {
    private String secretKey;
    private String issuer;

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
}
