package com.github.specht.event.sourcing.events;

import lombok.Getter;

@Getter
public class DebitEvent extends BaseEvent<String> {

    private Double amount;

    public DebitEvent(String id, Double amount) {
        super(id);
        this.amount = amount;
    }
}
