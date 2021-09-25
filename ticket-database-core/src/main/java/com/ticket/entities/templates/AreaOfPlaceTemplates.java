package com.ticket.entities.templates;

import lombok.*;

import javax.persistence.*;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "area_of_place_templates")
public class AreaOfPlaceTemplates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="code", length = 32, nullable = false, unique = true)
    private String code;

    @Column(name="name", length = 64, nullable = false)
    private String name;

    @Column(name = "max_count_places", nullable = false)
    private Integer maxCountPlaces;

    @Column(name = "isActive")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_template", referencedColumnName = "id")
    private PlaceTemplate place_template;

}
