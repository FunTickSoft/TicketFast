package com.ticket.entities.organization;


import lombok.*;

import javax.persistence.*;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "privilages")
public class Privileges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "rolestaff_id")
    private RoleStaff roleStaff;

    @Builder.Default
    @Column(name = "canCreateDiary", nullable = false)
    private Boolean canCreateDiary = true;

    @Builder.Default
    @Column(name = "canRefundAccept", nullable = false)
    private Boolean canRefundAccept = true;

    @Builder.Default
    @Column(name = "canUserRegDevices", nullable = false)
    private Boolean canUserRegDevices = true;

    @Builder.Default
    @Column(name ="isActive", nullable = false)
    private Boolean isActive = true;


}
