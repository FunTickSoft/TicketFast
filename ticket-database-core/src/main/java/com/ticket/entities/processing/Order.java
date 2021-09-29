package com.ticket.entities.processing;


import com.ticket.entities.account.Account;
import com.ticket.entities.account.UserPurchasingInfo;
import com.ticket.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false, length = 256)
    private String description;

    @Column(name = "orderNumber", nullable = false)
    private Long orderNumber;


    @Column(name = "amount", nullable = false)
    private Double amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    @Column(name = "orderStatus", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="userPurchasingInfo")
    private UserPurchasingInfo userPurchasingInfo;




}
