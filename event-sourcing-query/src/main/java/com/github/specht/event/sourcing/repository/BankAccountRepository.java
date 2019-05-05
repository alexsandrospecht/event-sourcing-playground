package com.github.specht.event.sourcing.repository;

import com.github.specht.event.sourcing.model.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, String> { }
