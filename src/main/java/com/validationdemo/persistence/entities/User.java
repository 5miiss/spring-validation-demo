package com.validationdemo.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String userName;
    private String password;
    private String email;

    private boolean deleted = false;
    @ManyToMany()
    @JoinTable(name = "user_roles"
    ,joinColumns =@JoinColumn(name = "user_id")
    ,inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
    private String refNo = UUID.randomUUID().toString();
}
