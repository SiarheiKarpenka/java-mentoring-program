package com.code.sample.event.service.requests;

public class EventRequestFailure {

    private String message;

    public EventRequestFailure(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
