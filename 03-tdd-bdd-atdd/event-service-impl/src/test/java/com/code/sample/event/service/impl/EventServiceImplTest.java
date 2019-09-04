package com.code.sample.event.service.impl;

import com.code.sample.event.service.EventService;
import com.code.sample.event.service.dto.Event;
import com.code.sample.event.service.dto.EventType;
import com.code.sample.event.service.impl.repository.EventRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class EventServiceImplTest {

    @TestConfiguration
    static class EventServiceImplTestContextConfiguration {

        @Bean
        public EventService eventService() {
            return new EventServiceImpl();
        }
    }

    @Autowired
    private EventService eventService;

    @MockBean
    private EventRepository eventRepository;

    @Before
    public void setUp() {
        Event event = new Event("Title 1", "Place 1", "Speaker 1", EventType.TECH_TALK, LocalDateTime.now());
        event.setEventId(1L);

        Mockito.when(eventRepository.findAll())
                .thenReturn(new ArrayList<Event>() {{
                    add(event);
                }});

        Mockito.when(eventRepository.findByTitle(event.getTitle()))
                .thenReturn(new ArrayList<Event>() {{
                    add(event);
                }});

        Mockito.when(eventRepository.findById(event.getEventId()))
                .thenReturn(Optional.of(event));

        Mockito.when(eventRepository.save(any(Event.class)))
                .thenReturn(event);

    }

    @Test
    public void getAllEvents() {
        String title = "Title 1";
        List<Event> events = eventService.getAllEvents();
        Assert.assertEquals(title, events.get(0).getTitle());
    }

    @Test
    public void getAllEventsByTitle() {
        String title = "Title 1";
        List<Event> events = eventService.getAllEventsByTitle(title);
        Assert.assertEquals(title, events.get(0).getTitle());
    }

    @Test
    public void getEvent() {
        Event event = eventService.getEvent(1L);
        Assert.assertTrue(event.getEventId().equals(1L));
    }

    @Test
    public void createEvent() {
        Event event = new Event("Title 1", "Place 1", "Speaker 1", EventType.TECH_TALK, LocalDateTime.now());
        event.setEventId(1L);
        Assert.assertTrue(eventService.createEvent(event).getEventId().equals(1L));
    }

    @Test
    public void updateEvent() {
        Event event = new Event("Title 1", "Place 1", "Speaker 1", EventType.TECH_TALK, LocalDateTime.now());
        event.setEventId(1L);
        Assert.assertTrue(eventService.updateEvent(event.getEventId(), event).getEventId().equals(1L));
    }
}