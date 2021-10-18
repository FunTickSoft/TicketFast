package com.ticket.exceptions;

public class AccountExpiredException extends RuntimeException{


    public AccountExpiredException() {
    }

    public AccountExpiredException(String message) {
        super(message);
    }
}
