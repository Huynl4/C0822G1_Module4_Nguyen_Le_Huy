package com.example.freshbe.service;

import com.example.freshbe.model.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    Optional<Account> findByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<Account> findById(Integer id);
    Boolean existsByUsername(String username);
    List<Account> findAll();
    void save(Account account);
}
