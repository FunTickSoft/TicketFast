package com.ticket.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ServiceUnavailableException extends RuntimeException{

    private String message;


}
