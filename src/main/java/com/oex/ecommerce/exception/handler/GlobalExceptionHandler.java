package com.oex.ecommerce.exception.handler;


import com.oex.ecommerce.dto.GenericResponse;
import com.oex.ecommerce.exception.customexceptions.InvalidPasswordException;
import com.oex.ecommerce.exception.customexceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = InvalidPasswordException.class)
    public final ResponseEntity<GenericResponse> handleInvalidPasswordException(InvalidPasswordException exception) {
        GenericResponse genericResponse = new GenericResponse(false, exception.getMessage(), "Invalid password", HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
        log.error("Handling Invalid password exception");
        log.error(exception.getMessage());
        return new ResponseEntity<>(genericResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<GenericResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {
        GenericResponse genericResponse = new GenericResponse(false, exception.getMessage(), "Resource not found", HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
        log.error("Handling Resource not found exception");
        log.error(exception.getMessage());
        return new ResponseEntity<>(genericResponse, HttpStatus.NOT_FOUND);
    }



}
