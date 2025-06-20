package com.jsw.restapi.section01.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Message {
    private int httpStatusCode;
    private String message;

    // 잘되면 200 리소스 파일 오류 404 내부 오류 500 get요청에 오류 405 권한 없으면 403 요청 값이 잘못 전달됨 400
}
