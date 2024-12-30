package com.util;

import java.util.HashMap;
import java.util.Map;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;


public class ResponseUtil {

    public static HttpResponse<Object> successResponse(Object data, String message, HttpStatus httpStatus) 
    {
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("data", data);
        resp.put("message", message);
        resp.put("code", httpStatus.getCode());
        resp.put("status", "success");
        return HttpResponse.status(httpStatus).body(resp);
    }

    public static HttpResponse<Object> successResponse(String message, HttpStatus httpStatus) 
    {
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("message", message);
        resp.put("code", httpStatus.getCode());
        resp.put("status", "success");
        return HttpResponse.status(httpStatus).body(resp);
    }

    public static HttpResponse<Object> failedResponse(Object errors, String message, HttpStatus httpStatus) 
    {
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("errors", errors);
        resp.put("message", message);
        resp.put("code", httpStatus.getCode());
        resp.put("status", "failed");
        return HttpResponse.status(httpStatus).body(resp);
    }

    public static HttpResponse<Object> failedResponse(String message, HttpStatus httpStatus) 
    {
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("message", message);
        resp.put("code", httpStatus.getCode());
        resp.put("status", "failed");
        return HttpResponse.status(httpStatus).body(resp);
    }

}
