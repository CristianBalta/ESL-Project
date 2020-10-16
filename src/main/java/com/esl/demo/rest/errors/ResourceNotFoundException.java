package com.esl.demo.rest.errors;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends CustomException {

    public ResourceNotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
