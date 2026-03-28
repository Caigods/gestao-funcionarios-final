package com.caigods.saam.gestao_funcionarios.business.exception;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {

        super(message);
    }
    public ConflictException(String message, Throwable throwable){
        super(message);
    }
}
