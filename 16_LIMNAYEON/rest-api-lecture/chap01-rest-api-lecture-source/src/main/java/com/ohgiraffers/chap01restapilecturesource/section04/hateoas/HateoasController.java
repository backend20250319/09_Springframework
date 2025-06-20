package com.ohgiraffers.chap01restapilecturesource.section04.hateoas;


import com.ohgiraffers.chap01restapilecturesource.section02.responseentity.ResponseMessage;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/hateoas")
public class HateoasController {

    private List<UserDTO> users;

    public HateoasController() {

        users = new ArrayList<>();
        users.add(new UserDTO(1, "user01", "pass01", "유관순"));
        users.add(new UserDTO(2, "user02", "pass02", "홍길동"));
        users.add(new UserDTO(3, "user03", "pass03", "이순신"));
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findAllUsers() {
        // Hateoas 설정
        List<EntityModel<UserDTO>> usersWithRel = users.stream().map(
                user ->
                        EntityModel.of(
                                user,
                                linkTo(methodOn(HateoasController.class).findUserByNo(user.getNo())).withSelfRel(),
                                linkTo(methodOn(HateoasController.class).findAllUsers()).withRel("users")

                        )
        ).toList();

        // 응답 바디 설정
        Map<String, Object> response = new HashMap<>();
        response.put("users", usersWithRel);

        // 응답 메세지 설정
        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", response);
        return ResponseEntity.ok().body(responseMessage);
    }

    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable("userNo") int userNo) {

        // 응답 헤더 설정 : JSON 응답이 default 이기는 하나 변경이 필요한 경우 HttpHeaders 설정 변경
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(
                new MediaType("application", "json", StandardCharsets.UTF_8)
        );

        // 응답 바디 설정
        Map<String, Object> response = new HashMap<>();
        response.put("users", users);

        // 응답 메세지 설정
        ResponseMessage responseMessage = new ResponseMessage(
                200, "조회 성공", response
        );

//        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(responseMessage);
    }
}
