package com.lab.haer.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus httpStatus, Object responseObject) {

        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", httpStatus.value());
        map.put("data", responseObject);

        return new ResponseEntity<Object>(map, httpStatus);

    }
}
