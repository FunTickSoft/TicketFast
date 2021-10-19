package com.ticket.account;


import lombok.*;

@Builder(toBuilder = true)
@ToString
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@Getter
public class TokenBody {

    private Long id;
    private String token;

}
