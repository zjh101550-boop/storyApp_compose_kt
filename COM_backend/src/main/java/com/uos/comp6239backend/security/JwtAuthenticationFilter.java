package com.uos.comp6239backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @title: JwtAuthenticationFilter
 * @Author Hym
 * @Date: 2024-03-18 7:19
 * @Description:
 * @Version 1.0
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JWTEncrypt jwtEncrypt;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("comp6239_token")) {
            token = token.substring(7);
            try {
                DefaultUser user = jwtEncrypt.decode(token, userId -> "temp");

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        user, null, user.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                // Handle token validation errors
            }
        }

        filterChain.doFilter(request, response);
    }
}

