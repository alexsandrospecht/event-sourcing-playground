package com.github.specht.event.sourcing.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BaseEvent<T> {

    private T id;

}