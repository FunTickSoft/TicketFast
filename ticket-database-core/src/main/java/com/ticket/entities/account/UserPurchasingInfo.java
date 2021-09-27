package com.ticket.entities.account;


import com.ticket.entities.processing.Order;
import com.ticket.entities.special.PaymentCard;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_purchasing_info")
public class UserPurchasingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "userPurchasingInfo", cascade = CascadeType.ALL)
    private List<PaymentCard> paymentCards;

    @OneToMany(mappedBy = "userPurchasingInfo", cascade = CascadeType.ALL)
    private List<Order> orders;

    @Column(name ="isACtive", nullable = false)
    private Boolean isActive;



}
