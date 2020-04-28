package com.wevioo.demo.infrastructure.exception;

import lombok.Getter;

public class BadDataArgumentException extends RuntimeException {
    @Getter
    private BadDataArgumentExceptionCode code;

    public BadDataArgumentException(String message, BadDataArgumentExceptionCode code) {
        super(message);
        this.code = code;
    }
}
