package com.ohgiraffers.springsecurity.command.service;

import com.ohgiraffers.springsecurity.command.dto.UserCreateRequest;
import com.ohgiraffers.springsecurity.command.entity.User;
import com.ohgiraffers.springsecurity.command.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommandService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    /*
     * 사용자의 정보를 입력받아서 JPA를 이용해서 사용자를 저장
     * 1. dto -> Entity (ModelMapper)
     * 2. 사용자에게 전달받은 비밀번호
     *    ex) pass01 -> 암호화 처리  BCryptPasswordEncoder(라이브러리 사용) encode
     * */
    public void registUser(UserCreateRequest request) {

        User user = modelMapper.map(request, User.class); // 비영속화 상태
        user.setEncodedPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user); // 영속화 상태
    }
}
