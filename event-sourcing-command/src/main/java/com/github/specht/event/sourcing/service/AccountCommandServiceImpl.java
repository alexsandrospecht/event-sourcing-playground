package com.github.specht.event.sourcing.service;

import com.github.specht.event.sourcing.command.CreditCommand;
import com.github.specht.event.sourcing.command.DebitCommand;
import com.github.specht.event.sourcing.command.CreateAccountCommand;
import com.github.specht.event.sourcing.model.AccountCreateDTO;
import com.github.specht.event.sourcing.model.CreditDTO;
import com.github.specht.event.sourcing.model.DebitDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountCommandServiceImpl implements AccountCommandService {

    @Autowired
    private CommandGateway commandGateway;

    @Override
    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO) {
        return commandGateway.send(new CreateAccountCommand(UUID.randomUUID().toString(), accountCreateDTO.getName(), accountCreateDTO.getStartingBalance()));
    }

    @Override
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, CreditDTO moneyCreditDTO) {
        return commandGateway.send(new CreditCommand(accountNumber, moneyCreditDTO.getCreditAmount()));
    }

    @Override
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, DebitDTO moneyDebitDTO) {
        return commandGateway.send(new DebitCommand(accountNumber, moneyDebitDTO.getDebitAmount()));
    }
}