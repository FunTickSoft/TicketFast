package com.ticket.entities.diarypack;


import com.ticket.entities.special.Organization;
import com.ticket.entities.templates.DiaryTemplate;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diary")
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Organization organization;

    @ManyToOne
    private DiaryTemplate diaryTemplate;



    @Temporal(TemporalType.DATE)
    private Date starDate;

    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Temporal(TemporalType.TIME)
    private Date endTime;




}
