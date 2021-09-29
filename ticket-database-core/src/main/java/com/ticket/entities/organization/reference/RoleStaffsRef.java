package com.ticket.entities.organization.reference;


import com.ticket.entities.organization.RoleStaff;
import com.ticket.entities.organization.Staff;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role_staff")
public class RoleStaffsRef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="rolestaff_id", nullable = false)
    private RoleStaff roleStaff;

    @ManyToOne
    @JoinColumn(name ="staff_id", nullable = false)
    private Staff staff;

    @Builder.Default
    @Column(name="isActive", nullable = false)
    private Boolean isActive = true;


}
