package com.ticket.entities.diarypack.reference;


import com.ticket.entities.diarypack.Diary;
import com.ticket.entities.organization.Organization;
import lombok.*;

import javax.persistence.*;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organization_diary_reg")
public class OrganizationDiaryReg {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;

    @Builder.Default
    @Column(name ="isActive", nullable = false)
    private Boolean isActive = true;

}
