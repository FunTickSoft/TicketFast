package com.ticket.entities.processing;


import lombok.*;

import javax.persistence.*;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_contents")
public class OrderContents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}
