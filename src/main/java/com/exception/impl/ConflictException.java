package com.exception.impl;

import com.exception.APIException;

import io.micronaut.http.HttpStatus;

public class ConflictException extends APIException {

    public ConflictException(String message) {
        super(message, HttpStatus.CONFLICT);
    }

}
