package com.trek.creatorplatform.content;

public class InvalidUserException extends IllegalArgumentException{
    public InvalidUserException(String msg)
    {
        super(msg);;
    }
}
