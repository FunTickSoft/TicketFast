package com.ticket.repositories;

import com.ticket.entities.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByLoginEmail(String loginEmail);

    Optional<Account> findByLogin(String login);

    Optional<Account> findByLoginOrLoginEmail(String loginOrEmail);

    void deleteAccountById(Long id);

    List<Account> findAll();


}
