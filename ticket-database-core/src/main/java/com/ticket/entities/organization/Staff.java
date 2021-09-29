package com.ticket.entities.organization;


import com.ticket.entities.account.UserInfo;
import com.ticket.entities.organization.reference.RoleStaffsRef;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "userinfo_id")
    private UserInfo userInfo;

    @OneToMany(mappedBy = "roleStaff", cascade = CascadeType.ALL)
    private Set<RoleStaffsRef> roleStaffsRefSet;

    @Builder.Default
    @Column(name = "isActive", nullable = false)
    private Boolean isActive = true;


}
