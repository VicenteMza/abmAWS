package com.crudAWS.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DniExistException extends RuntimeException{
    public DniExistException (String message){
        super(message);
    }
}
