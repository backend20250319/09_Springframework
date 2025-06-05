package com.ohgiraffers.chap01restapilecturesource.section02.responseentity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entity")
public class ResponseEntityController {

    private List<UserDTO> user;

    public ResponseEntityController() {
        user = new ArrayList<>();
        user.add(new UserDTO(1, "user01", "pass01", "유관순"));
        user.add(new UserDTO(2, "user02", "pass02", "홍길동"));
        user.add(new UserDTO(3, "user03", "pass03", "이순신"));
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findAllUsers(){
        // 응답 헤더 설정 : JSON 응답이 default 이기는 하나 변경이 필요한 경우 HttpHeaders 설정 변경
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(
                new MediaType("application", "json", StandardCharsets.UTF_8)
        );

        // 응답 바디 설정
        Map<String, Object> response = new HashMap<>();
        response.put("users", user);

        // 응답 메세지 설정
        ResponseMessage responseMessage = new ResponseMessage(
                200, "조회 성공", response
                );

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo){
        // 응답 헤더 설정 : JSON 응답이 default 이기는 하나 변경이 필요한 경우 HttpHeaders 설정 변경
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(
                new MediaType("application", "json", StandardCharsets.UTF_8)
        );

        // 응답 바디 설정
        Map<String, Object> response = new HashMap<>();
        UserDTO foundUser = user.stream().filter(user -> user.getNo() == userNo).findFirst().get();
        response.put("user", foundUser);

        // 응답 메세지 설정
        ResponseMessage responseMessage = new ResponseMessage(
                200, "조회 성공", response
        );

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseMessage> registUser(@RequestBody UserDTO userDTO){

        int lastUserNo = user.get(user.size() - 1).getNo();
        userDTO.setNo(lastUserNo + 1);
        user.add(userDTO);

        return ResponseEntity
                .created(URI.create("/entity/users/" + user.get(user.size() -1).getNo()))
                        .build();

    }

    @PutMapping("/users/{userNo}")
    public ResponseEntity<Void> modifyUser(
            @PathVariable int userNo, @RequestBody UserDTO userDTO
    ){
        UserDTO foundUser = user.stream().filter(user -> user.getNo() == userNo).findFirst().get();
        foundUser.setPwd(userDTO.getPwd());
        foundUser.setName(userDTO.getName());

        return ResponseEntity.created(URI.create("/entity/users/" + userNo)).build();
    }

    @DeleteMapping("/users/{userNo}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userNo){
        UserDTO foundUser = user.stream().filter(user->user.getNo() == userNo).findFirst().get();
        user.remove(userNo);
        return ResponseEntity.noContent().build();
    }

}
