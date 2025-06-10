package com.jsw.springsecurity.command.service;


import com.jsw.springsecurity.command.dto.request.UserCreateRequest;
import com.jsw.springsecurity.command.entity.User;
import com.jsw.springsecurity.command.repository.UserRepository;
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
    * 사용자의 정보를 입력 받아서 JPA를 이용해서 사용자를 저장
    * 1. dto -> Entity(ModelMapper)
    * 2. 사용자에게 전달받은 비밀번호 ex) pass01 -> 보안성의 문제로 암호화 처리를 해준다.
    *                                          BcryptEncode의 encode를 사용해서 암호화를 해준다.
    * */
    public void registUser(UserCreateRequest request) {
        User user = modelMapper.map(request, User.class);
        user.setEncodedPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
    }
}
