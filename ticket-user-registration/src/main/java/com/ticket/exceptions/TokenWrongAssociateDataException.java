package com.ticket.exceptions;

public class TokenWrongAssociateDataException extends RuntimeException{

    public TokenWrongAssociateDataException() {
    }

    public TokenWrongAssociateDataException(String message) {
        super(message);
    }
}
