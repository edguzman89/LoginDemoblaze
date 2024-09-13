package com.sophossolutions.exceptions;

public class Diferencias extends AssertionError{

    private static final long serialVersion = 1L;

    public Diferencias (String equipo, Throwable cause){
        super(equipo, cause);
    }


}
