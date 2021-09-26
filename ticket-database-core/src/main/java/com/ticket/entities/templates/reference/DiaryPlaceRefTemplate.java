package com.ticket.entities.templates.reference;

import com.ticket.entities.templates.DiaryTemplate;
import com.ticket.entities.templates.PlaceTemplate;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diary_place_reference")
public class DiaryPlaceRefTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "diary_template_id")
    private DiaryTemplate diaryTemplate;

    @ManyToOne
    @JoinColumn(name = "place_template_id")
    private PlaceTemplate placeTemplate;

    @Column(name = "register")
    private LocalDateTime register = LocalDateTime.now();

    @Builder.Default
    @Column(name = "isActive")
    private Boolean isActive = true;



}
