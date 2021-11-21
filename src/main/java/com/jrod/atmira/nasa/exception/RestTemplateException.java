package com.jrod.atmira.nasa.exception;

/**
 * @author Jesús Rodríguez
 */
public class RestTemplateException extends RuntimeException {
    private static final String DESCRIPTION = "Error to connect with nasa API";

    public RestTemplateException(){
        super(DESCRIPTION);
    }

    public RestTemplateException(String detail) {
        super(DESCRIPTION + ", " + detail);
    }
}
