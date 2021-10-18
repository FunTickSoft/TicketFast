package com.ticket.entities.diarypack;


import com.ticket.entities.diarypack.reference.DiaryPlaceReg;
import com.ticket.entities.diarypack.reference.OrganizationDiaryReg;
import com.ticket.entities.templates.DiaryTemplate;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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


    @OneToMany(mappedBy = "diary")
    private Set<OrganizationDiaryReg> organizationsDiaryReg;

    @OneToMany(mappedBy = "diary")
    private Set<DiaryPlaceReg> diaryPlaceRegs;

    @OneToOne
    @JoinColumn(name = "diary_template_id", referencedColumnName = "id")
    private DiaryTemplate diaryTemplate;

    @Temporal(TemporalType.DATE)
    private Date starDate;

    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Temporal(TemporalType.TIME)
    private Date endTime;

    @JoinColumn(name = "isActive", nullable = false)
    private Boolean isActive;


}
