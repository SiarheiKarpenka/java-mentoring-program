package com.code.sample.event.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventId;

    private String title;

    private String place;

    private String speaker;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    private LocalDateTime dateTime;

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
}
