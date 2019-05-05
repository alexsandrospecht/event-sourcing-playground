package com.github.specht.event.sourcing.model.aggregate;

import com.github.specht.event.sourcing.command.CreateAccountCommand;
import com.github.specht.event.sourcing.command.CreditCommand;
import com.github.specht.event.sourcing.command.DebitCommand;
import com.github.specht.event.sourcing.events.AccountCreatedEvent;
import com.github.specht.event.sourcing.events.CreditEvent;
import com.github.specht.event.sourcing.events.DebitEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Slf4j
@Getter
@Aggregate
@NoArgsConstructor
public class AccountAggregate {

    @AggregateIdentifier
    private String id;
    private String name;
    private Double accountBalance;

    @CommandHandler
    public AccountAggregate(CreateAccountCommand cmd) {
        log.info("Handling {} command: {}", cmd.getClass().getSimpleName(), cmd);
        Assert.hasLength(cmd.getId(), "Id should not be empty or null.");
        Assert.hasLength(cmd.getName(), "Name should not be empty or null.");
        apply(new AccountCreatedEvent(cmd.getId(), cmd.getName(), cmd.getAccountBalance()));
        log.info("Done handling {} command: {}", cmd.getClass().getSimpleName(), cmd);
    }

    @CommandHandler
    public void handle(CreditCommand cmd) {
        log.info("Handling {} command: {}", cmd.getClass().getSimpleName(), cmd);
        Assert.hasLength(cmd.getId(), "Id should not be empty or null.");
        Assert.notNull(cmd.getAmount(), "Amount should not be empty or null.");
        apply(new CreditEvent(cmd.getId(), cmd.getAmount()));
        log.info("Done handling {} command: {}", cmd.getClass().getSimpleName(), cmd);
    }

    @CommandHandler
    public void handle(DebitCommand cmd) {
        log.info("Handling {} command: {}", cmd.getClass().getSimpleName(), cmd);
        Assert.hasLength(cmd.getId(), "Id should not be empty or null.");
        Assert.notNull(cmd.getAmount(), "Amount should not be empty or null.");
        apply(new DebitEvent(cmd.getId(), cmd.getAmount()));
        log.info("Done handling {} command: {}", cmd.getClass().getSimpleName(), cmd);
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event) {
        log.info("Handling {} events: {}", event.getClass().getSimpleName(), event);
        this.id = event.getId();
        this.name = event.getName();
        this.accountBalance = event.getAccountBalance();
        log.info("Done handling {} events: {}", event.getClass().getSimpleName(), event);
    }

    @EventSourcingHandler
    public void on(CreditEvent event) {
        log.info("Handling {} events: {}", event.getClass().getSimpleName(), event);
        this.accountBalance = accountBalance + event.getAmount();
        log.info("Done handling {} events: {}", event.getClass().getSimpleName(), event);
    }

    @EventSourcingHandler
    public void on(DebitEvent event) {
        log.info("Handling {} events: {}", event.getClass().getSimpleName(), event);
        this.accountBalance = accountBalance - event.getAmount();
        log.info("Done handling {} events: {}", event.getClass().getSimpleName(), event);
    }

}