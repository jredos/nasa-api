package com.jrod.atmira.nasa.exception;

/**
 * @author Jesús Rodríguez
 */
public class ParamDaysInvalidException extends RuntimeException {

    private static final String DESCRIPTION = "Days parameter must be >= 1 or <= 7";

    public ParamDaysInvalidException(){
        super(DESCRIPTION);
    }

    public ParamDaysInvalidException(String detail) {
        super(DESCRIPTION + ", " + detail);
    }
}
