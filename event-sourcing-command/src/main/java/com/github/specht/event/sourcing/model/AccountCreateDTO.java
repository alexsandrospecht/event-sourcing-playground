package com.github.specht.event.sourcing.model;

import lombok.Data;

@Data
public class AccountCreateDTO {

    private Double startingBalance;
    private String name;

}

