package com.example.freshbe.service.impl;

import com.example.freshbe.model.Role;
import com.example.freshbe.model.RoleName;
import com.example.freshbe.repository.IRoleRepository;
import com.example.freshbe.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return iRoleRepository.findByName(name);
    }
}
