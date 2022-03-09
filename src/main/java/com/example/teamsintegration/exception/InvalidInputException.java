package com.example.teamsintegration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class InvalidInputException extends RuntimeException{

    public InvalidInputException(){

    }
    public InvalidInputException(String message){
        super(message);
    }
}
