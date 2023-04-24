package com.example.freshbe.service.impl;

import com.example.freshbe.model.Account;
import com.example.freshbe.repository.IAccountRepository;
import com.example.freshbe.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public Optional<Account> findByUsername(String username) {
        return iAccountRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return iAccountRepository.existsByEmail(email);
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return iAccountRepository.findById(id);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return iAccountRepository.existsByUsername(username);
    }

    @Override
    public List<Account> findAll() {
        return iAccountRepository.findAll();
    }

    @Override
    public void save(Account account) {
        iAccountRepository.save(account);
    }
}
