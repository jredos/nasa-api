package com.jrod.atmira.nasa.exception;

/**
 * @author Jesús Rodríguez
 */
public class ParamDaysNotFoundException extends RuntimeException {

    private static final String DESCRIPTION = "Param days required";

    public ParamDaysNotFoundException(){ super(DESCRIPTION); }

    public ParamDaysNotFoundException(String detail) { super(DESCRIPTION + ", " + detail); }
}
