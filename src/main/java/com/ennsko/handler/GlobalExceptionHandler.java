package com.ennsko.handler;

import com.ennsko.exception.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidTuningSetException.class)
    public ResponseEntity<Map<String, String>> handleInvalidTuningSet(InvalidTuningSetException ex) {
        Map<String, String> body = new HashMap<>();
        body.put("error", "InvalidTuningSet");
        body.put("message", ex.getMessage());
        return ResponseEntity.badRequest().body(body);
    }

}
