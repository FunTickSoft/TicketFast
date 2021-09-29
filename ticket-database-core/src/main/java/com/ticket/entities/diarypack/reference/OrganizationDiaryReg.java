package com.ticket.entities.diarypack.reference;


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



    @Builder.Default
    @Column(name ="isActive", nullable = false)
    private Boolean isActive = true;

}
