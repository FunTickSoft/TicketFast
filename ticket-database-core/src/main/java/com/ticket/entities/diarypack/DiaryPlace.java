package com.ticket.entities.diarypack;


import com.ticket.entities.templates.PlaceTemplate;
import lombok.*;

import javax.persistence.*;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diary_place")
public class DiaryPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "diary_template_id")
    private PlaceTemplate places;

    @Column(name ="maxCountTicket", nullable = false)
    private Integer maxCountTicket;

    @Builder.Default
    @Column(name ="hasArea", nullable = false)
    private Boolean hasArea =true;

    @Builder.Default
    @Column(name = "soldCountTicket")
    private Integer soldCountTicket = 0;

    @Builder.Default
    @Column(name = "isActive")
    private Boolean isActive = true;



}
