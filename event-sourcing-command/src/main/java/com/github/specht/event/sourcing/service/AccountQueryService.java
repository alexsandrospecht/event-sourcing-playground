package com.github.specht.event.sourcing.service;

import java.util.List;

public interface AccountQueryService {

    List<Object> listEventsForAccount(String accountNumber);

}