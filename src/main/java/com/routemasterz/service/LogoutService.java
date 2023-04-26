package com.routemasterz.service;

import com.routemasterz.model.UserEntity;
import com.routemasterz.util.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
public class LogoutService implements LogoutHandler {
    private final JWTUtil jwtUtil;
    Logger logger = LoggerFactory.getLogger(LogoutService.class);

    private final UserDetailsServiceImpl userDetailsService;

    public LogoutService(JWTUtil jwtUtil, UserDetailsServiceImpl userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Authentication authentication) {

        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }

        String jwt = authHeader.substring(7);
        String email = jwtUtil.getSubject(jwt);//email in our case
        logger.warn("logout - email "+email);

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserEntity userEntity = userDetailsService.loadUserByUsername(email);
            logger.warn("logout - userEntity "+userEntity);

            if (jwtUtil.isTokenValid(jwt, userEntity.getEmail())) {

                jwtUtil.setTokenToBlacklist(jwt);
                SecurityContextHolder.clearContext();
            }
        }
    }
}

