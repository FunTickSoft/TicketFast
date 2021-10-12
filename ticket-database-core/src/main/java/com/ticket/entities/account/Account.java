package com.ticket.entities.account;


import lombok.*;

import javax.persistence.*;


@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "login", nullable = false, length = 64)
    private String login;

    @Column(name = "login_email", nullable = false, length = 64)
    private String loginEmail;

    @Column(name = "password", nullable = false, length = 1024)
    private String password;

    @Column(name = "status", nullable =false)
    private Byte status;

    @Builder.Default
    @Column(name = "enabled",  nullable = false)
    private Boolean enabled = true;

    @Builder.Default
    @Column(name = "accountNonExpired")
    private Boolean accountNonExpired = true;

    @Builder.Default
    @Column(name = "accountNonLocked")
    private Boolean accountNonLocked = true;

    @Builder.Default
    @Column(name = "credentialsNonExpired")
    private Boolean credentialsNonExpired = true;

    @OneToOne(mappedBy = "account")
    @PrimaryKeyJoinColumn
    private UserInfo userInfo;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private UserPurchasingInfo userPurchasingInfo;


}
