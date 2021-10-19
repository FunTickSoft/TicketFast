package com.ticket.response;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter(AccessLevel.PUBLIC)
public class Response {

    private String message;
    private Integer code;

}
