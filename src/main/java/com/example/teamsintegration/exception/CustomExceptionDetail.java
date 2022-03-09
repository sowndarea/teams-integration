package com.example.teamsintegration.exception;

import lombok.Data;

@Data
public class CustomExceptionDetail {
    private String title;
    private int status;
    private String detail;
    private long timeStamp;
    private String message;


}
