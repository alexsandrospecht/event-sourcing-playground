package com.github.specht.event.sourcing.command;

import lombok.Getter;

@Getter
public class DebitCommand extends CreditCommand {

    public DebitCommand(String id, Double amount) {
        super(id, amount);
    }
}
