package com.ticket.entities.diarypack.reference;


import com.ticket.entities.diarypack.Diary;
import com.ticket.entities.templates.PlaceTemplate;
import lombok.*;

import javax.persistence.*;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diary_place_reg")
public class DiaryPlaceReg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;

    @ManyToOne
    @JoinColumn(name = "place_template_id")
    private PlaceTemplate placeTemplate;


    @Builder.Default
    @Column(name ="isActive", nullable = false)
    private Boolean isActive = true;

}
