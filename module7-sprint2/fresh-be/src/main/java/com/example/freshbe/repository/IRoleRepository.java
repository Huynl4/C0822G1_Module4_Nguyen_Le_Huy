package com.example.freshbe.repository;

import com.example.freshbe.model.Role;
import com.example.freshbe.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(RoleName name);
}
