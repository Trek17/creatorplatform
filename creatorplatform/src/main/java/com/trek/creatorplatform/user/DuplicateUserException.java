package com.trek.creatorplatform.user;

import com.trek.creatorplatform.user.dto.ErrorResponse;

public class DuplicateUserException extends RuntimeException{
    public DuplicateUserException(String msg)
    {
        super(msg);
    }
}
