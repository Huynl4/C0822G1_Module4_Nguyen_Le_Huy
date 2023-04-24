package com.example.freshbe.service;

import com.example.freshbe.model.Role;
import com.example.freshbe.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
