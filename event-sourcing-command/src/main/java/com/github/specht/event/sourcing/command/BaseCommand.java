package com.github.specht.event.sourcing.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BaseCommand<T> {

    @TargetAggregateIdentifier
    public T id;

}
