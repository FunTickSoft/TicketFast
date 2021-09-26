package com.ticket.entities.templates;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diary_template")
public class DiaryTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "shortDescription", nullable = false, length = 512)
    private String shortDescription;

    @Column(name = "description", nullable = false, length = 2048)
    private String description;

    @Temporal(TemporalType.DATE)
    private Date starDate;

    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Temporal(TemporalType.TIME)
    private Date endTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "diary_place_template",
            joinColumns = @JoinColumn(name = "diary_template_id"),
            inverseJoinColumns = @JoinColumn(name = "place_template_id")
    )
    private Set<PlaceTemplate> placeTemplates;


}