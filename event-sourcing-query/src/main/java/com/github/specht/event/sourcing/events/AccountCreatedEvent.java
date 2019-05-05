package com.github.specht.event.sourcing.events;

import lombok.Getter;

@Getter
public class AccountCreatedEvent extends BaseEvent<String> {

    private Double accountBalance;
    private String name;

    public AccountCreatedEvent(String id, String name, Double balance) {
        super(id);
        this.accountBalance = balance;
        this.name = name;
    }

}
