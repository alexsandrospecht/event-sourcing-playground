package com.github.specht.event.sourcing.service;

import com.github.specht.event.sourcing.model.AccountCreateDTO;
import com.github.specht.event.sourcing.model.CreditDTO;
import com.github.specht.event.sourcing.model.DebitDTO;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {

    CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);
    CompletableFuture<String> creditMoneyToAccount(String accountNumber, CreditDTO moneyCreditDTO);
    CompletableFuture<String> debitMoneyFromAccount(String accountNumber, DebitDTO moneyDebitDTO);
}
