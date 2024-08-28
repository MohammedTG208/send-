package com.example.capstion3.Advice;


import com.example.capstion3.API.APIException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerAdvice {

    @ExceptionHandler(value = APIException.class)
    public ResponseEntity ApiException(APIException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
}
