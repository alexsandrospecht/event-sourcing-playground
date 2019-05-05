package com.github.specht.event.sourcing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventSourcingCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventSourcingCommandApplication.class, args);
	}

}
