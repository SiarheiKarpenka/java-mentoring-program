package com.code.sample.event.service;

import com.code.sample.event.service.dto.Event;

import java.util.List;

public interface EventService {

    /**
     * Find all registered Events
     *
     * @return {@link List<Event>}
     */
    List<Event> getAllEvents();

    /**
     * Get Event
     *
     * @param id {@link Event} id
     * @return existing {@link Event} object or <i>null</i> if {@link Event} with specified id was not found
     */
    Event getEvent(Long id);

    /**
     * Delete Event
     *
     * @param id {@link Event} id
     * @return existing {@link Event} object or <i>null</i> if {@link Event} with specified id was not found
     */
    Event deleteEvent(Long id);

    /**
     * Create Event
     *
     * @param event {@link Event}
     * @return {@link Event} object
     */
    Event createEvent(Event event);

    /**
     * Update Event
     *
     * @param id    {@link Event} id
     * @param event {@link Event}
     * @return existing {@link Event} object or <i>null</i> if {@link Event} with specified id was not found
     */
    Event updateEvent(Long id, Event event);

}