package com.code.sample.event.service.impl;

import com.code.sample.event.service.EventService;
import com.code.sample.event.service.dto.*;
import com.code.sample.event.service.impl.repository.EventMongoRepository;
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

import java.math.BigInteger;
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
    private EventMongoRepository eventRepository;

    @Before
    public void setUp() {
        Speaker speaker = new Speaker("Siarhei", "Karpenka", new Email("sergeykarpenko88@gmail.com"));
        Event event = new Event("Title 1", new Address("Street", "City", "Country"), speaker, EventType.TECH_TALK, LocalDateTime.now());
        event.setId(BigInteger.ONE);

        Mockito.when(eventRepository.findAll())
                .thenReturn(new ArrayList<Event>() {{
                    add(event);
                }});

        Mockito.when(eventRepository.findByTitle(event.getTitle()))
                .thenReturn(new ArrayList<Event>() {{
                    add(event);
                }});

        Mockito.when(eventRepository.findById(event.getId()))
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
        Event event = eventService.getEvent(BigInteger.ONE);
        Assert.assertTrue(event.getId().equals(BigInteger.ONE));
    }

    @Test
    public void createEvent() {
        Speaker speaker = new Speaker("Siarhei", "Karpenka", new Email("sergeykarpenko88@gmail.com"));
        Event event = new Event("Title 1", new Address("Street", "City", "Country"), speaker, EventType.TECH_TALK, LocalDateTime.now());
        event.setId(BigInteger.ONE);
        Assert.assertTrue(eventService.createEvent(event).getId().equals(BigInteger.ONE));
    }

    @Test
    public void updateEvent() {
        Speaker speaker = new Speaker("Siarhei", "Karpenka", new Email("sergeykarpenko88@gmail.com"));
        Event event = new Event("Title 1", new Address("Street", "City", "Country"), speaker, EventType.TECH_TALK, LocalDateTime.now());
        event.setId(BigInteger.ONE);
        Assert.assertTrue(eventService.updateEvent(event.getId(), event).getId().equals(BigInteger.ONE));
    }
}