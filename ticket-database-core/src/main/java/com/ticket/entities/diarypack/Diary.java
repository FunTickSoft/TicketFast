package com.ticket.entities.diarypack;


import com.ticket.entities.diarypack.reference.DiaryAreaPlaceReg;
import com.ticket.entities.diarypack.reference.DiaryPlaceReg;
import com.ticket.entities.diarypack.reference.DiaryReg;
import com.ticket.entities.diarypack.reference.OrganizationDiaryReg;
import com.ticket.entities.organization.Organization;
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
    private Set<DiaryReg> diaryRegs;

    @OneToMany(mappedBy = "diary")
    private Set<OrganizationDiaryReg> organizationsDiaryReg;

    @OneToMany(mappedBy = "diary")
    private Set<DiaryPlaceReg> diaryPlaceRegs;

    @OneToMany(mappedBy = "diary")
    private Set<DiaryAreaPlaceReg> diaryAreaPlaceRegs;

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
