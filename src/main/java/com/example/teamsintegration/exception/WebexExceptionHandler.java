package com.example.teamsintegration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class WebexExceptionHandler {
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Object> handleRuntimeException(InvalidInputException exception , HttpServletRequest request ){


        CustomExceptionDetail errorDetail = new CustomExceptionDetail();
        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDetail.setTitle("InternalServerError");
        errorDetail.setDetail(exception.getMessage());
        errorDetail.setMessage(exception.getClass().getName());

        return new ResponseEntity<>(errorDetail, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

