package com.jsw.cqrs.exception;


import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ErrorCode erroCode;

    public BusinessException(ErrorCode erroCode) {
        super(erroCode.getMessage());
        this.erroCode = erroCode;
    }
}
