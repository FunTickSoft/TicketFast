package com.ticket.entities.special;

import com.ticket.entities.organization.Organization;
import com.ticket.enums.AddressType;
import lombok.*;

import javax.persistence.*;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address_book")
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city", nullable = false, length = 128)
    private String city;

    @Column(name = "address", nullable = false, length = 512)
    private String address;

    @Column(name = "houseNumber", nullable = false)
    private String houseNumber;

    @Column(name = "corps", nullable = false)
    private String corps;

    @Enumerated(EnumType.ORDINAL)
    private AddressType addressType;

    @ManyToOne
    @JoinColumn(name = "organization", referencedColumnName = "id")
    private Organization organization;



}
