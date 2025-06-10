package com.jsw.springsecurity.query.service;


import com.jsw.springsecurity.query.dto.UserDTO;
import com.jsw.springsecurity.query.dto.UserDetailResponse;
import com.jsw.springsecurity.query.dto.UserListResponse;
import com.jsw.springsecurity.query.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserQueryService {
    
    private final UserMapper userMapper;

    public UserDetailResponse getUserDetail(String username) {
        UserDTO user = Optional.ofNullable(
                userMapper.findUserByUserName(username)
        ).orElseThrow(() -> new RuntimeException("유저 정보 찾지 못함"));
        return UserDetailResponse.builder().user(user).build();
    }

    public UserListResponse getAllUsers() {
        List<UserDTO> users = userMapper.findAllUsers();
        return UserListResponse.builder().users(users).build();
    }
}
