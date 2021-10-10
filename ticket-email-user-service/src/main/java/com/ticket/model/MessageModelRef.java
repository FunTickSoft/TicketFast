package com.ticket.model;


import com.example.email.model.MessageMail;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Builder(toBuilder = true)
@ToString
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@Getter
public class MessageModelRef {

    @NotEmpty
    private String recipientAddress;

    @NotEmpty
    @Email
    private String subject;

    @NotEmpty
    private String text;


    public MessageMail getMessageMail() {
        return MessageMail.builder().recipientAddress(recipientAddress).subject(subject).text(text).build();
    }


}
