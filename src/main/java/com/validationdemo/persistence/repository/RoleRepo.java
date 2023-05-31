package com.validationdemo.persistence.repository;

import com.validationdemo.persistence.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Integer> {
    boolean existsByRoleName(String roleName);
    Role findByRoleName(String roleName);
}
