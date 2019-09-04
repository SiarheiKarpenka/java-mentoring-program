package com.code.sample.event.service.workshop;

import com.code.sample.event.service.EventService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkshopEventService implements EventService {

    /**
     * Get Events
     *
     * @return {@link List<String>} representing Workshop Events
     */
    public List<String> getEvents() {
        return Stream.of(
                "Project Increment Planning",
                "Search Relevancy Tuning via SeaS"
        )
                .map(WorkshopEventService::prefix)
                .collect(Collectors.toList());
    }

    /**
     * Add Prefix
     *
     * @param input input string
     * @return {@link String} representing input {@link String} with concatenated prefix
     */
    static String prefix(String input) {
        var result = "Workshop: " + input;
        return result;
    }
}
