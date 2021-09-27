package com.ticket.entities.account;

import com.ticket.entities.processing.Order;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

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

    @OneToOne(mappedBy = "account")
    @PrimaryKeyJoinColumn
    private UserInfo userInfo;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private UserPurchasingInfo userPurchasingInfo;


}
