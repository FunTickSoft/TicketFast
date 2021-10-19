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

    @Email
    @NotEmpty(message = "Email is required.")
    private String email;

    private String phoneNumber;

    @NotEmpty(message = "Password is required.")
    private String password;

    @NotEmpty(message = "Password confirmation is required.")
    private String confirmPassword;

    private AccountStatus status;

    private Boolean enabled;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

}
