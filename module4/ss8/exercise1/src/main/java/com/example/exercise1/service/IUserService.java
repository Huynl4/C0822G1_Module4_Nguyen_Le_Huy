package com.example.exercise1.service;

import com.example.exercise1.model.User;

import java.util.List;

public interface IUserService {
    void save(User user);
    List<User> findAll();
}
