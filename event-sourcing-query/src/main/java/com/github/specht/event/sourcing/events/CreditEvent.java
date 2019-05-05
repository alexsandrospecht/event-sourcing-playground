package com.github.specht.event.sourcing.events;

import lombok.Getter;

@Getter
public class CreditEvent extends BaseEvent<String> {

    private Double amount;

    public CreditEvent(String id, Double amount) {
        super(id);
        this.amount = amount;
    }

}
