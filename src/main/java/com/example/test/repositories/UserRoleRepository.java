package com.example.test.repositories;

import com.example.test.models.UserRole;
import com.example.test.models.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
    UserRole findUserRoleByRole(Role role);
}
