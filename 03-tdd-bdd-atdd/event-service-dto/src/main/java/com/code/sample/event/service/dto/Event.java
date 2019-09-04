package com.code.sample.event.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long eventId;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String place;

    @Getter
    @Setter
    private String speaker;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private EventType eventType;

    @Getter
    @Setter
    private LocalDateTime dateTime;

    public Event() {
    }

    public Event(String title,
                 String place,
                 String speaker,
                 EventType eventType,
                 LocalDateTime dateTime) {
        this.title = title;
        this.place = place;
        this.speaker = speaker;
        this.eventType = eventType;
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) &&
                Objects.equals(place, event.place) &&
                Objects.equals(speaker, event.speaker) &&
                eventType == event.eventType &&
                Objects.equals(dateTime, event.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, place, speaker, eventType, dateTime);
    }
}
