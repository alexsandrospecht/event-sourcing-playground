package com.github.specht.event.sourcing.command;

import lombok.Getter;

@Getter
public class CreateAccountCommand extends BaseCommand<String> {

    private Double accountBalance;

    private String name;

    public CreateAccountCommand(String id, String name, Double accountBalance) {
        super(id);
        this.name = name;
        this.accountBalance = accountBalance;
    }

}