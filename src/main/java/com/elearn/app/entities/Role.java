package com.elearn.app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    private String roleId;

    private String roleName;

    @ManyToMany
    @JoinTable(name = "user_roles")
    private Set<User> users=new HashSet<>();
}
