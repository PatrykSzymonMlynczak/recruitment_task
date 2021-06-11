package com.example.recruitment_task.exceptions;

import org.kohsuke.github.GHFileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RepositoryNotFoundException.class)
    protected ResponseEntity<?> handleNotFoundException(
            RepositoryNotFoundException ex){

        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(GHFileNotFoundException.class)
    protected ResponseEntity<?> handleNotFoundException(
            GHFileNotFoundException ex){

        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, "User not Found -> " + ex.getMessage()));
    }

    @ExceptionHandler(IOException.class)
    protected ResponseEntity<?> handleNotIOException(
            IOException ex){

        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
    }

    private ResponseEntity<ApiError> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
