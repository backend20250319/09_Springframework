package com.ohgiraffers.restapi.section02.responseentity;

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
public class ResponeseEntityController {

    private List<UserDTO> users;

    public ResponeseEntityController() {
        users = new ArrayList<>();
        users.add(new UserDTO(1, "user01", "pass01", "유관순"));
        users.add(new UserDTO(2, "user02", "pass02", "홍길동"));
        users.add(new UserDTO(3, "user03", "pass03", "이순신"));
    }

    // 전체 회원 목록 조회
    @GetMapping("/user")
    public ResponseEntity<ResponseMessage> findAllUser() {
        /* 응답 헤더 설정 : JSON 응답이 default 이기는 하나 변경이 필요한 경우 HttpHeaders 설정 변경 */
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(
                new MediaType("application", "json", StandardCharsets.UTF_8)
        );

        /* 응답에 대한 body 설정 */
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", users);

        /* 응답 메세지 설정 */
        ResponseMessage responseMessage = new ResponseMessage(
                200, "조회 성공", responseMap
        );

        return new ResponseEntity<>(responseMessage, httpHeaders, HttpStatus.OK);
    }

    // 회원 번호로 회원 조회
    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo) {
        /* 응답 헤더 설정 : JSON 응답이 default 이기는 하나 변경이 필요한 경우 HttpHeaders 설정 변경 */
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(
                new MediaType("application", "json", StandardCharsets.UTF_8)
        );

        /* 응답에 대한 body 설정 */
        Map<String, Object> responseMap = new HashMap<>();
        UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo).findFirst().get();
        responseMap.put("user", foundUser);

        /* 응답 메세지 설정 */
        ResponseMessage responseMessage = new ResponseMessage(
                200, "조회 성공", responseMap
        );

        return new ResponseEntity<>(responseMessage, httpHeaders, HttpStatus.OK);
    }

    // 신규 회원 등록
    @PostMapping("/users")
    public ResponseEntity<ResponseMessage> registUser(@RequestBody UserDTO userDTO) {

        int lastUserNo = users.get(users.size() - 1).getNo();
        userDTO.setNo(lastUserNo + 1);
        users.add(userDTO);

        return ResponseEntity.created(URI.create("/entity/users" + users.get(users.size() - 1).getNo())).build();
    }

    // 회원 정보 수정
    @PutMapping("/users/{userNo}")
    public ResponseEntity<Void> modifyuser(
            @PathVariable int userNo, @RequestBody UserDTO userDTO) {
        UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo).findFirst().get();
        foundUser.setPwd(userDTO.getPwd());
        foundUser.setName(userDTO.getName());

        return ResponseEntity.created(URI.create("/entity/users" + userNo)).build();
    }

    // 회원 삭제
    @DeleteMapping("/users/{userNo}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userNo) {
        UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo).findFirst().get();
        users.remove(foundUser);

        return ResponseEntity.noContent().build();
    }
}
