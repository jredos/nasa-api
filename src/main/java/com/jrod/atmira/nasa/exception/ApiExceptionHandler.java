package com.jrod.atmira.nasa.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jesús Rodríguez
 */
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({ParamDaysNotFoundException.class})
    public ResponseEntity<Object> notFoundRequest(HttpServletRequest request, RuntimeException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception, request.getRequestURI()), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class, ParamDaysInvalidException.class})
    public ResponseEntity<Object> badRequest(RuntimeException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception, ""), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({RestTemplateException.class})
    public ResponseEntity<Object> fatalErrorUnexpectedException(RuntimeException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception, ""), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
