package com.ticket.entities.templates;


import com.ticket.entities.organization.Organization;
import com.ticket.entities.templates.reference.TicketAoPlaceRefTemplate;
import com.ticket.entities.templates.reference.TicketPlaceRefTemplate;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ticket_template")
public class TicketTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="cost")
    private Double cost;

    @ManyToOne(optional = false)
    @JoinColumn(name = "organization", referencedColumnName = "id")
    private Organization organization;

    @Column(name="isActive")
    private Boolean isActive;

    @OneToMany(mappedBy = "ticketTemplate")
    private Set<TicketAoPlaceRefTemplate> ticketArenaReference;


    @OneToMany(mappedBy = "ticketTemplate")
    private Set<TicketPlaceRefTemplate> ticketPlaceRefTemplates;

}
