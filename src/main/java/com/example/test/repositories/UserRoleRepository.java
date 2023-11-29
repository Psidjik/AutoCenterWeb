package com.example.test.repositories;

import com.example.test.models.BaseEntity;
import com.example.test.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {

}
