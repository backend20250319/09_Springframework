package com.ohgiraffers.springsecurity.command.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserCreateRequest {

    private final String username;
    private final String password;
    
    // 추가 회원 가입 시 필요한 데이터가 있으면 추후 추가 예정

}
