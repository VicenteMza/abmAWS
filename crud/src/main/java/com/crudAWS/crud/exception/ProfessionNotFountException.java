package com.crudAWS.crud.exception;

public class ProfessionNotFountException extends RuntimeException{
    public ProfessionNotFountException(String description){
        super("Profesion no encontrada para la descripcion: " + description);
    }
}
