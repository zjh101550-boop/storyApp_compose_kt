//package com.uos.comp6239backend.security;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//
//import java.util.Collection;
//
///**
// * @title: DefaultUser
// * @Author Hym
// * @Date: 2024-03-18 6:01
// * @Description:继承自spring security的类，用于用户权限管理
// * @Version 1.0
// */
//public class DefaultUser extends User {
//    private static final long serialVersionUID = -737120919971895085L;
//    private final Integer userId;
//    private final Integer userType;
//
//    public DefaultUser(Integer userId, Integer userType,String username, String password, Collection<? extends GrantedAuthority> authorities) {
//        super(username, password, authorities);
//        this.userId = userId;
//        this.userType = userType;
//    }
//
//    public DefaultUser(Integer userId, Integer userType, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
//        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
//        this.userId=userId;
//        this.userType = userType;
//    }
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public Integer getUserType() {
//        return userType;
//    }
//}
