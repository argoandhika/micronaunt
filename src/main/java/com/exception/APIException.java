package com.exception;

import io.micronaut.http.HttpStatus;

public class APIException extends Exception {

    private HttpStatus httpStatus;

    public APIException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
