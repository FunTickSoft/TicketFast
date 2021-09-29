package com.ticket.entities.diarypack;


import lombok.*;

import javax.persistence.*;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diary_place_area")
public class DiaryPlaceArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




}
