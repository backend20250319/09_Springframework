package com.ohgiraffers.springsecurity.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity  // HTTP 요청의 인증/인가 -> 처리할 수 있게 도와줌
@EnableMethodSecurity   // @PreAuthorize @PostAuthorize
@RequiredArgsConstructor
public class SecurityConfig {

    /* 비밀번호 암호화 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /* 어떤 URL이 보호되고, 공개되고, 로그인, 로그아웃, 세션 처리 진행할 메소드 */
    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {
        // CSRF 처리 비활성화
        http.csrf(AbstractHttpConfigurer::disable)
                // 세션 로그인을 사용하지 않고 -> 토큰 인증 방식 로그인으로 설정
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(HttpMethod.POST, "/api/v1/users", "/api/v1/auth/login", "/api/v1/auth/refresh").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/me").hasAuthority("USER")
                                .anyRequest().authenticated() // : 모든 요청에 인증이 필요함
                );
                /* cors 설정 */
                http.cors(cors -> cors.configurationSource(corsConfigurationSource()));
                return http.build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:5173"); // 허용할 도메인
        config.addAllowedHeader("*"); // 모든 헤더 허용
        config.addAllowedMethod("*"); // 모든 HTTP 메소드 허용
        config.setAllowCredentials(true);// 자격 증명(쿠키 등) 허용
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);// 모든 경로에 대해 설정
        return source;
    }
}
