package com.code.sample.event.service.requests;

import com.code.sample.event.service.dto.Event;

public class CreateEventRequest {

    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}