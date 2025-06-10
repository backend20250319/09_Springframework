package com.jsw.springsecurity.query.mapper;

import com.jsw.springsecurity.query.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface UserMapper {

    UserDTO findUserByUserName(String username);

    List<UserDTO> findAllUsers();

}
