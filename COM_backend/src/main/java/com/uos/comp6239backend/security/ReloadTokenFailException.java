package com.uos.comp6239backend.security;

import org.springframework.security.core.AuthenticationException;

/**
 * @title: ReloadTokenFailException
 * @Author Hym
 * @Date: 2024-03-18 4:11
 * @Description:
 * @Version 1.0
 */
public class ReloadTokenFailException extends AuthenticationException {
    private static final long serialVersionUID = 2445485658204308790L;

    public ReloadTokenFailException(String msg, Throwable t) {
        super(msg, t);
    }

    public ReloadTokenFailException(String msg) {
        super(msg);
    }
}
