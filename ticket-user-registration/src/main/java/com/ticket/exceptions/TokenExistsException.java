package com.ticket.exceptions;

public class TokenExistsException extends RuntimeException{

    public TokenExistsException() {
    }

    public TokenExistsException(String message) {
        super(message);
    }
}
