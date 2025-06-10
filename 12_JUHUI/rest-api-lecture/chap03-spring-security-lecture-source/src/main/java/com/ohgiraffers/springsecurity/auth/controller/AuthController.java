package com.ohgiraffers.springsecurity.auth.controller;

import com.ohgiraffers.springsecurity.auth.dto.LoginRequest;
import com.ohgiraffers.springsecurity.auth.dto.TokenResponse;
import com.ohgiraffers.springsecurity.auth.service.AuthService;
import com.ohgiraffers.springsecurity.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<TokenResponse>> login(@RequestBody LoginRequest request){

        TokenResponse tokenResponse = authService.login(request);
        return buildTokenResponse(tokenResponse);
    }

    /* accessToken 과 refreshToken 을 body 와 cookie 에 담아 반환 */
    private ResponseEntity<ApiResponse<TokenResponse>> buildTokenResponse(TokenResponse tokenResponse) {

        ResponseCookie cookie = createRefreshTokenCookie
    }
}
