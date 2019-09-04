package com.code.sample.event.service.impl.repository;

import com.code.sample.event.service.dto.Event;
import com.code.sample.event.service.dto.EventType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
public class EventRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EventRepository eventRepository;

    @After
    public void cleanUp() {
        entityManager.clear();
    }

    @Test
    public void findByTitle() {
        Event event = new Event("Title 1", "Place 1", "Speaker 1", EventType.TECH_TALK, LocalDateTime.now());
        entityManager.persist(event);
        entityManager.flush();

        List<Event> events = eventRepository.findByTitle(event.getTitle());

        Assert.assertEquals(event.getTitle(), events.get(0).getTitle());
    }

    @Test
    public void findAll() {
        for (int i = 0; i < 10; i++) {
            Event event = new Event("Title " + i, "Place " + i, "Speaker " + i, EventType.WORKSHOP, LocalDateTime.now());
            entityManager.persist(event);
        }
        entityManager.flush();

        List<Event> events = (List<Event>) eventRepository.findAll();

        Assert.assertEquals(10, events.size());
    }
}