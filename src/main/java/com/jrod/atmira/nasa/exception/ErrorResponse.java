package com.jrod.atmira.nasa.exception;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Jesús Rodríguez
 */
@Data
public class ErrorResponse {

    private String timestamp;
    private String exception;
    private String message;
    private String path;

    public ErrorResponse(Exception exception, String path){
        this.timestamp = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now());
        this.exception = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
        this.path = path;
    }
}
