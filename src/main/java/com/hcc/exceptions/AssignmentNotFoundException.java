package com.hcc.exceptions;

//added this class for exceptions

public class AssignmentNotFoundException extends RuntimeException{


    private static final long serialVersionUID = 1L;

    public AssignmentNotFoundException(String message) {
        super(message);
    }
}
