package com.ticket.model;


import lombok.*;

@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@Getter
public class MessageModel {

    private String recipientAddress;
    private String subject;
    private String text;

}
