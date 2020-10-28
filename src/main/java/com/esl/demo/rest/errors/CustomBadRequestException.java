package com.esl.demo.rest.errors;

import org.springframework.http.HttpStatus;

public class CustomBadRequestException extends CustomException {

    public CustomBadRequestException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }

    public CustomBadRequestException(String message) {
        super(message);
    }
}
