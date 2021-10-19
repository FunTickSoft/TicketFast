package com.ticket.exceptions;

public class AccountCredentialsExpiredException extends RuntimeException{

    public AccountCredentialsExpiredException() {
    }

    public AccountCredentialsExpiredException(String message) {
        super(message);
    }
}
