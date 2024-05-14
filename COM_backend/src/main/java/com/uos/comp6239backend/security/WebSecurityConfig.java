//package com.uos.comp6239backend.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * @title: WebSecurityConfig
// * @Author Hym
// * @Date: 2024-03-15 20:53
// * @Description:
// * @Version 1.0
// */
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    //   自动注入根据用户名查找用户信息的 userDetailsService
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    public UserDetailsService userDetailsService() {
//        return userDetailsService;
//    }
//
//    // 控制哪些内容可以访问，访问成功、失败后的逻辑
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//        // 启用HTTPS
//            .requiresChannel()
//                .anyRequest()
//                .requiresSecure()
//                .and()
//
//
//
//                .authorizeRequests()
//                .antMatchers("/").permitAll() //首页允许所有人访问，暂定，一会修改为登录所有人访问
////                .antMatchers("/swagger-ui/**",
////                        "/login/**",
////                        "/v3/api-docs/**").authenticated()
//                .antMatchers("/swagger-ui/**",
//                        "/login/**",
//                        "/v3/api-docs/**").permitAll()
//                .anyRequest().permitAll();
////                .and()
////                .httpBasic();
//        http.addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//    }
//
//    // 查找用户能否访问
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user") // 用户名
//                .password("{noop}password") // 密码，{noop}是密码编码的前缀，表示不使用密码编码器
//                .roles("USER");
//        auth.userDetailsService(userDetailsService());
//    }
//}
