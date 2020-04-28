package com.wevioo.demo.domain.exception;

import lombok.Getter;

public class BusinessException extends RuntimeException {
    @Getter
    private BusinessExceptionCode code;

    public BusinessException(String message, BusinessExceptionCode code) {
        super(message);
        this.code = code;
    }
}
