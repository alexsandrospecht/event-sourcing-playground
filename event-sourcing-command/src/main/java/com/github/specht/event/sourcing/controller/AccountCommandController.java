package com.github.specht.event.sourcing.controller;

import com.github.specht.event.sourcing.model.AccountCreateDTO;
import com.github.specht.event.sourcing.model.CreditDTO;
import com.github.specht.event.sourcing.model.DebitDTO;
import com.github.specht.event.sourcing.service.AccountCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/bank-account")
public class AccountCommandController {

    @Autowired
    private AccountCommandService accountCommandService;

    @PostMapping
    public CompletableFuture<String> createAccount(@RequestBody AccountCreateDTO accountCreateDTO) {
        return accountCommandService.createAccount(accountCreateDTO);
    }

    @PostMapping(value = "/{accountNumber}/credit")
    public CompletableFuture<String> creditMoneyToAccount(@PathVariable(value = "accountNumber") String accountNumber,
                                                          @RequestBody CreditDTO moneyCreditDTO) {

        return accountCommandService.creditMoneyToAccount(accountNumber, moneyCreditDTO);
    }

    @PostMapping(value = "{accountNumber}/debit")
    public CompletableFuture<String> debitMoneyFromAccount(@PathVariable(value = "accountNumber") String accountNumber,
                                                           @RequestBody DebitDTO moneyDebitDTO) {

        return accountCommandService.debitMoneyFromAccount(accountNumber, moneyDebitDTO);
    }
}