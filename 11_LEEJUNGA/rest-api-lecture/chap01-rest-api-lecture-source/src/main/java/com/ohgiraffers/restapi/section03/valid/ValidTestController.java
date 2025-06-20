package com.ohgiraffers.restapi.section03.valid;

import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/valid")
public class ValidTestController {
    @GetMapping("/users/{userNo}")
    public ResponseEntity<?> findByUserNo(@PathVariable String userNo) {
        boolean check = true;
         if(check) throw new UserNotFoundException("🚫회원 정보를 찾을 수 없습니다. ");

         return ResponseEntity.ok().build();
    }

    @PostMapping("/users")
    public ResponseEntity<?> registUser(@Validated @RequestBody UserDTO userDTO) {
        return ResponseEntity.created(URI.create("/valid/users/1")).build();
    }
}
