package com.ticket.representative;


import com.ticket.enums.AccountStatus;
import lombok.*;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
public class AccountRepr {

    private Long id;

    @NotEmpty
    private String login;

    @NotEmpty
    @Email
    private String loginEmail;

    private String phoneNumber;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    private AccountStatus status;

    private Boolean enabled;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;






}
