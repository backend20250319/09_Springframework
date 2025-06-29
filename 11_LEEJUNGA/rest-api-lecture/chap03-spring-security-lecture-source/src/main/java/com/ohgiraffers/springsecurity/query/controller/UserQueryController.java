package com.ohgiraffers.springsecurity.query.controller;

import com.ohgiraffers.springsecurity.common.ApiResponse;
import com.ohgiraffers.springsecurity.query.dto.UserDetailResponse;
import com.ohgiraffers.springsecurity.query.dto.UserListResponse;
import com.ohgiraffers.springsecurity.query.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserQueryController {

    private final UserQueryService userQueryService;

    @GetMapping("/users/me")
    public ResponseEntity<ApiResponse<UserDetailResponse>> getUserDetail(
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        UserDetailResponse response = userQueryService.getUserDetail(userDetails.getUsername());
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    // 간단한 URL 패턴보다 복잡한 비즈니스 로직이나 메서드 단위의 세밀한 보안 제어가 필요한 경우
    // @PreAuthorize : 메소드 호출 전에 조건 평가
    // @PostAuthorize : 반환 결과에 기반한 후 처리 보안
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin/users")
    public ResponseEntity<ApiResponse<UserListResponse>> getUsers() {
        UserListResponse response = userQueryService.getAllUsers();
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
