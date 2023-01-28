package com.squareroot.controller.advice;

import com.squareroot.dto.ExceptionDto;
import com.squareroot.exception.QuadraticEquationException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(QuadraticEquationException.class)
    public ResponseEntity<ExceptionDto> handleQuadraticEquationException(QuadraticEquationException e) {
        ExceptionDto exceptionDto = ExceptionDto.builder()
                .code(HttpStatus.BAD_REQUEST)
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}
