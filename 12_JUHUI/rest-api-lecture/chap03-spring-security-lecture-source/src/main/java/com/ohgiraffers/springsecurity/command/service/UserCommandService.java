package com.ohgiraffers.springsecurity.command.service;

import com.ohgiraffers.springsecurity.command.dto.request.UserCreateRequest;
import com.ohgiraffers.springsecurity.command.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommandService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    /*
     * 사용자의 정보를 입력받아서 JPA를 이용해서 사용자를 저장
     * 1. dto -> Entity (ModelMapper)
     * 2. 사용자에게전달받은 비밀번호 ex) pass01 -> 암호화  BcryptEncoder encode
     * */
    public void registUser(UserCreateRequest request) {
    }
}
