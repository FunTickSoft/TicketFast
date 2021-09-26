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

    @Column(name = "login_email", nullable = false, length = 64)
    private String loginEmail;

    @Column(name = "password", nullable = false, length = 1024)
    private String password;


    @Column(name = "status", nullable =false)
    private Byte status;

    @Column(name = "isActive")
    private Boolean isActive;

    @OneToOne(fetch = FetchType.LAZY)
    private UserInfo userInfo;


}
