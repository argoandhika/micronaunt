package com.controller;


import com.exception.APIException;
import com.util.ResponseUtil;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Produces
@Singleton
public class GlobalHandlingErrorController {

    @Singleton
    @Requires(classes = {APIException.class, ExceptionHandler.class})
    public static class APIExceptionHandler implements ExceptionHandler<APIException, HttpResponse<Object>> {
        @Override
        public HttpResponse<Object> handle(HttpRequest req, APIException ex) {
            return ResponseUtil.failedResponse(ex.getMessage(), ex.getHttpStatus());
        }
    }

    @Singleton
    @Requires(classes = {Exception.class, ExceptionHandler.class})
    public static class InternalServerErrorHandler implements ExceptionHandler<Exception, HttpResponse<Object>> {
        @Override
        public HttpResponse<Object> handle(HttpRequest req, Exception ex) {
            return ResponseUtil.failedResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}