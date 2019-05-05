package com.github.specht.event.sourcing.exception;

public class BankAccountNotFoundException extends RuntimeException {

    public BankAccountNotFoundException() {
        super("Bank account not found!");
    }
}
