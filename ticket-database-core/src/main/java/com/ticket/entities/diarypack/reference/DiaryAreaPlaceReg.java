package com.ticket.entities.diarypack.reference;


import com.ticket.entities.diarypack.Diary;
import com.ticket.entities.templates.AreaTemplates;
import lombok.*;

import javax.persistence.*;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diary_area_place_reg")
public class DiaryAreaPlaceReg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private AreaTemplates areaTemplates;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;


    @Builder.Default
    @Column(name ="isActive", nullable = false)
    private Boolean isActive = true;


}
