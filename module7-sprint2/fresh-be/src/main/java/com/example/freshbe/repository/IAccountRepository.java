package com.example.freshbe.repository;

import com.example.freshbe.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account,Integer> {
    Optional<Account> findByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<Account> findById(Integer id);
    Boolean existsByUsername(String username);
}
