package com.wevioo.demo.bdd.utils;

public class ApiException extends Exception {

    public ApiException(String message, Throwable t) {
        super(message,t);
    }
}
