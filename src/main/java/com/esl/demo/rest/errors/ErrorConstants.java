package com.esl.demo.rest.errors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.stream.Collectors;

public final class ErrorConstants {

    public static final String ERR_ENTITY_NOT_FOUND = "error.entityNotFound";
    public static final String CODE_VALIDATION_FAILED = "error.codeValidationFailed";

    public static List<String> getErrorList(Errors errors) {
        return errors.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
    }
}
