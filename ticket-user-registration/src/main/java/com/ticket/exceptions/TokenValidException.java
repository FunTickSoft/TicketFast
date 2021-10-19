package com.ticket.exceptions;

public class TokenValidException extends RuntimeException{
    public TokenValidException() {
    }

    public TokenValidException(String message) {
        super(message);
    }
}
