package com.github.specht.event.sourcing.controller;

import com.github.specht.event.sourcing.model.BankAccount;
import com.github.specht.event.sourcing.repository.BankAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/bank-accounts")
public class BankAccountController {

    @Autowired
    private BankAccountRepository repository;

    @GetMapping
    public ResponseEntity<Iterable<BankAccount>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }
}