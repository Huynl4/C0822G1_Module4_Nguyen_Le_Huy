package com.example.exercise1.service.impl;

import com.example.exercise1.model.User;
import com.example.exercise1.repository.IUserRepository;
import com.example.exercise1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }
}
