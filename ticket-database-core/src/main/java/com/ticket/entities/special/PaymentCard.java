package com.ticket.entities.special;

import com.ticket.entities.account.UserPurchasingInfo;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment_cards")
public class PaymentCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cardNumber", nullable = false, length = 1024)
    private Integer cardNumber;

    @Column(name = "owner", nullable = false, length = 64)
    private String owner;

    @Temporal(TemporalType.DATE)
    private Date expiredDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userPurchasingInfo_id")
    private UserPurchasingInfo userPurchasingInfo;



}
