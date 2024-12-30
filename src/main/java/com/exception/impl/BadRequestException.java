package com.exception.impl;

import com.exception.APIException;

import io.micronaut.http.HttpStatus;

public class BadRequestException extends APIException {

    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

}
