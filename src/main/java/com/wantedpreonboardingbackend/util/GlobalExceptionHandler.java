package com.wantedpreonboardingbackend.util;

import com.wantedpreonboardingbackend.controller.dto.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResponse> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = getMessage(e.getBindingResult());
        CommonResponse commonResponse = CommonResponse.builder()
                .code(StatusCode.BAD_REQUEST.getCode())
                .message(message)
                .build();
        return new ResponseEntity(commonResponse, HttpStatus.OK);
    }

    public String getMessage(BindingResult bindingResult) {
        List<FieldError> errors = bindingResult.getFieldErrors();
        return errors.get(0).getDefaultMessage();
    }
}
