package com.ticket.entities.account;


import com.ticket.entities.account.ref.AccountRoleRef;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder(toBuilder = true)
@Getter
@Setter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "role")
    private List<AccountRoleRef> accountRoleRef;

    @Builder.Default
    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;

}


