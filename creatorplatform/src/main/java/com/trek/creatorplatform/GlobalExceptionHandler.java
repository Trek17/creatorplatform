package com.trek.creatorplatform;

import com.trek.creatorplatform.user.DuplicateUserException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.trek.creatorplatform.user.dto.ErrorResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateUserException.class)
            @ResponseStatus(HttpStatus.CONFLICT)
            public ErrorResponse handleDuplicateUser(DuplicateUserException ex)
    {
        return new ErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleNotValidException(MethodArgumentNotValidException ex)
    {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        Map<String,String> errorMap = new HashMap<>();
        for(FieldError e: errors)
        {
            errorMap.put(e.getField(),
            e.getDefaultMessage());
        }
        return new ErrorResponse("Validation Failed", errorMap);
    }
}
