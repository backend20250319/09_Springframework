package com.jsw.springsecurity.query.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDetailResponse {
    private UserDTO user;
}
