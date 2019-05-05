package com.github.specht.event.sourcing.command;

import lombok.Getter;

@Getter
public class CreditCommand extends BaseCommand<String> {

    private Double amount;

    public CreditCommand(String id, Double amount) {
        super(id);
        this.amount = amount;
    }

}
