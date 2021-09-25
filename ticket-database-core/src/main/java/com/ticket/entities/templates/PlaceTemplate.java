package com.ticket.entities.templates;


import com.ticket.entities.special.Organization;
import com.ticket.entities.special.RentInfo;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "place_template")
public class PlaceTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Column(name = "shortDescription", length = 128)
    private String shortDescription;

    @Column(name = "description", length = 2048)
    private String description;

    @Column(name = "city", nullable = false, length = 128)
    private String city;

    @Column(name = "address", nullable = false, length = 512)
    private String address;

    @Column(name = "houseNumber", nullable = false)
    private String houseNumber;

    @Column(name = "corps", nullable = false)
    private String corps;

    @Column(name = "isRent", nullable = false)
    private Boolean isRent;

    @Column(name = "deleteAfterRentExpire", nullable = false)
    private Boolean deleteAfterRentExpire;

    @OneToOne(fetch = FetchType.LAZY)
    private RentInfo rentInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToMany(mappedBy = "place_template", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AreaOfPlaceTemplates> areas;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive = true;

}
