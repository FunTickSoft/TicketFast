package com.ticket.entities.diarypack.reference;


import com.ticket.entities.diarypack.Diary;
import com.ticket.entities.templates.DiaryTemplate;
import lombok.*;

import javax.persistence.*;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diary_reg")
public class DiaryReg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;

    @ManyToOne
    @JoinColumn(name = "diary_template_id")
    private DiaryTemplate diaryTemplate;


    @Builder.Default
    @Column(name ="isActive", nullable = false)
    private Boolean isActive = true;


}
