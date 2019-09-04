package com.code.sample.event.service.techtalk;

import com.code.sample.event.service.EventService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TechTalkEventService implements EventService {

    /**
     * Get Events
     *
     * @return {@link List<String>} representing TechTalk Events
     */
    public List<String> getEvents() {
        return Stream.of(
                "Software development process",
                "BDD,ATDD, UAT",
                "Communication",
                "Embedded servers",
                "Infrastructure as Code",
                "Concurrency and Multi-threading Architecture",
                "Modern Web App Architecture",
                "Antipatterns",
                "Domain-driven design",
                "Microservices",
                "Legacy code with refactoring",
                "Architecture of high-load/BigData projects",
                "RDMS and SQL Advance",
                "Database Transaction Isolation and Locking",
                "Implementing Caching",
                "Database Migration tools",
                "Java API Overview",
                "API-First Architecture",
                "REST API Architecture"
        )
                .map(TechTalkEventService::prefix)
                .collect(Collectors.toList());
    }

    /**
     * Add Prefix
     *
     * @param input input string
     * @return {@link String} representing input {@link String} with concatenated prefix
     */
    static String prefix(String input) {
        var result = "Tech-talk JMP: " + input;
        return result;
    }
}
