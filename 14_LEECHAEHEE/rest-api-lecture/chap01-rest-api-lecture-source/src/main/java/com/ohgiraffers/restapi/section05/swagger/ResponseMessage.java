package com.ohgiraffers.restapi.section05.swagger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseMessage {
    public int httpStatus;
    public String message;
    private Map<String, Object> results;
}
