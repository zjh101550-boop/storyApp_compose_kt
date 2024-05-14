//package com.uos.comp6239backend.security;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
///**
// * @title: CustomizeUserDetailsService
// * @Author Hym
// * @Date: 2024-03-15 23:17
// * @Description:
// * @Version 1.0
// */
//
////在spring security框架内，我们应该自定义一个继承了UserDetailsService 的类，并把它注入到spring 容器内，
//// 这个类比如叫做MyUserDetailsService 应该重载loadUserByUsername方法，并返回该用户名对应的密码和角色
//// 然后spring security就会把这个用户放行,configure(AuthenticationManagerBuilder auth)可以动态的决定用户是否被放行
//
////用于根据用户名提取用户信息（密码，角色），以供spring security判断权限
//@Service
//public class CustomizeUserDetailsService implements UserDetailsService {
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // 这里应该查询数据库或者其他地方来检索用户信息
//        // 这里仅仅提供一个硬编码的例子
//        if ("admin".equals(username)) {
//            return User.builder()
//                    .username("admin")
//                    .password(passwordEncoder().encode("admin123"))
//                    .roles("ADMIN") // Spring会将roles转换为authorities
//                    .build();
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//    }
//
//    private PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
