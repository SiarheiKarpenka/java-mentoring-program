package com.code.sample.event.service.impl.repository;

import com.code.sample.event.service.dto.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EventMongoRepositoryTest {

    @Autowired
    private EventMongoRepository eventMongoRepository;

    @Autowired
    private SpeakerMongoRepository speakerMongoRepository;

    @Before
    public void setUp() {
        Speaker speaker = new Speaker("Siarhei", "Karpenka", new Email("sergeykarpenko88@gmail.com"));
        assertNull(speaker.getId());
        speakerMongoRepository.save(speaker);
        assertNotNull(speaker.getId());
        Event event1 = new Event("Title 1", new Address("Street", "City", "Country"), speaker, EventType.WORKSHOP, LocalDateTime.now());
        Event event2 = new Event("Title 2", new Address("Street", "City", "Country"), speaker, EventType.WORKSHOP, LocalDateTime.now());
        assertNull(event1.getId());
        assertNull(event2.getId());
        eventMongoRepository.save(event1);
        eventMongoRepository.save(event2);
        assertNotNull(event1.getId());
        assertNotNull(event2.getId());
    }

    @After
    public void tearDown() {
        eventMongoRepository.deleteAll();
        speakerMongoRepository.deleteAll();
    }

    @Test
    public void findByTitle_Equals() {
        List<Event> events = eventMongoRepository.findByTitle("Title 1");
        assertNotNull(events);
        assertEquals(1, events.size());
        Event resultEvent = events.get(0);
        assertEquals("Title 1", resultEvent.getTitle());
        assertEquals(new Address("Street", "City", "Country"), resultEvent.getAddress());
        assertEquals(EventType.WORKSHOP, resultEvent.getEventType());
    }

    @Test
    public void testDataUpdate() {
        List<Event> events = eventMongoRepository.findByTitle("Title 2");
        Event resultEvent = events.get(0);
        resultEvent.setTitle("Title update");
        eventMongoRepository.save(resultEvent);
        events = eventMongoRepository.findByTitle("Title update");
        resultEvent = events.get(0);
        assertNotNull(resultEvent);
        assertEquals("Title update", resultEvent.getTitle());
    }
}