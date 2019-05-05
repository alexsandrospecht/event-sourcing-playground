package com.github.specht.event.sourcing.processors;

import com.github.specht.event.sourcing.events.AccountCreatedEvent;
import com.github.specht.event.sourcing.events.CreditEvent;
import com.github.specht.event.sourcing.events.DebitEvent;
import com.github.specht.event.sourcing.exception.BankAccountNotFoundException;
import com.github.specht.event.sourcing.model.BankAccount;
import com.github.specht.event.sourcing.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
@ProcessingGroup("amqpEvents")
public class BankAccountEventProcessor {

    @Autowired
    private BankAccountRepository repository;

    @EventHandler
    public void on(AccountCreatedEvent event) {
        BankAccount bankAccount = repository.save(new BankAccount(event.getId(), event.getName(), event.getAccountBalance()));
        log.info("A bank account was added! {}", bankAccount );
    }

    @EventHandler
    public void on(CreditEvent event) {
        BankAccount account = repository.findById(event.getId())
                .orElseThrow(BankAccountNotFoundException::new);
        account.setBalance(account.getBalance() + event.getAmount());
        repository.save(account);
        log.info("A bank account balance was updated! {}", account);
    }

    @EventHandler
    public void on(DebitEvent event) {
        BankAccount account = repository.findById(event.getId())
                .orElseThrow(BankAccountNotFoundException::new);
        account.setBalance(account.getBalance() - event.getAmount());
        repository.save(account);
        log.info("A bank account balance was updated! {}", account);
    }
}