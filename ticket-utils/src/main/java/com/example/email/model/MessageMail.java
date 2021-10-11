package com.example.email.model;


import lombok.*;

import java.io.Serializable;


@Builder(toBuilder = true)
@ToString
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@Getter
public class MessageMail implements Serializable {

    private String recipientAddress;
    private String subject;
    private String text;


}
