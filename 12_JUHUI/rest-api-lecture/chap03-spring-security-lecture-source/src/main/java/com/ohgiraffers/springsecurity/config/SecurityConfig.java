package com.ohgiraffers.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // HTTP 요청의 인증/인가를 처리할 수 있게 도와주는 어노테이션
@EnableMethodSecurity // @PreAuthorize @PostAuthorize 인가할 때 권한이 맞는지 확인하는 어노테이션
public class SecurityConfig {

    // 비밀번호 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 어떤 URL 이 보호되고 공개되고 로그인, 로그아웃, 세션 등 이 안에서 처리
    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {

    }
}
