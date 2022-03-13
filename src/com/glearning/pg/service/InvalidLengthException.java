package com.glearning.pg.service;

public class InvalidLengthException extends Exception {
    public InvalidLengthException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
}