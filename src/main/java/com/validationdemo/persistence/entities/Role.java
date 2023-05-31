package com.validationdemo.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {
    @Id
     @GeneratedValue(strategy = GenerationType.TABLE,generator = "roleTableGen")
     @TableGenerator(name = "roleTableGen",initialValue = 0,allocationSize = 15, table = "id_generator",
     pkColumnName = "id_key", pkColumnValue = "role_id",valueColumnName = "id_value")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)

    private String roleName;
}
