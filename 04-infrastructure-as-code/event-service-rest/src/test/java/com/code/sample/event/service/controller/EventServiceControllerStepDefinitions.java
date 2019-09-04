package com.code.sample.event.service.controller;

import com.code.sample.event.service.controller.util.LocalDateTimeConverter;
import com.code.sample.event.service.dto.Event;
import com.code.sample.event.service.dto.EventType;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Application.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventServiceControllerStepDefinitions {

    private RestTemplate restTemplate = new RestTemplate();

    @LocalServerPort
    protected int port;

    private String getEventServiceHost() {
        return "http://localhost:" + port;
    }

    private ResponseEntity<Event> responseEntity;

    @When("^the client calls POST '(.+)' and Body with Event with title: '(.+)', place: '(.+)', speaker '(.+)', event type '(WORKSHOP|TECH_TALK)', date '(.+)'\\.?")
    public void createEvent(String url,
                            String title,
                            String place,
                            String speaker,
                            EventType eventType,
                            @Transform(LocalDateTimeConverter.class) LocalDateTime dateTime) {
        Event event = new Event(title, place, speaker, eventType, dateTime);
        HttpEntity<Event> request = new HttpEntity<>(event);
        responseEntity = restTemplate.exchange(getEventServiceHost() + url, HttpMethod.POST, request, Event.class);
    }

    @When("^the client calls PUT '(.+)' and Body with Event with title: '(.+)', place: '(.+)', speaker '(.+)', event type '(WORKSHOP|TECH_TALK)', date '(.+)'\\.?")
    public void updateEvent(String url,
                            String title,
                            String place,
                            String speaker,
                            EventType eventType,
                            @Transform(LocalDateTimeConverter.class) LocalDateTime dateTime) {
        Event event = new Event(title, place, speaker, eventType, dateTime);
        HttpEntity<Event> request = new HttpEntity<>(event);
        responseEntity = restTemplate.exchange(getEventServiceHost() + url, HttpMethod.PUT, request, Event.class);
    }

    @When("^the client calls DELETE '(.+)'?")
    public void deleteEvent(String url) {
        responseEntity = restTemplate.exchange(getEventServiceHost() + url, HttpMethod.DELETE, null, Event.class);
    }

    @When("^the client calls GET '(.+)'?")
    public void getEvent(String url) {
        HttpEntity<Event> request = new HttpEntity<>(new Event());
        responseEntity = restTemplate.exchange(getEventServiceHost() + url, HttpMethod.GET, request, Event.class);
    }

    @Then("^the client receives status code of (\\d+)$")
    public void validateStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, responseEntity.getStatusCodeValue());
    }

    @And("^the client receives Event with title: '(.+)', place: '(.+)', speaker '(.+)', event type '(WORKSHOP|TECH_TALK)', date '(.+)'\\.?")
    public void validateResponseBody(String title,
                                     String place,
                                     String speaker,
                                     EventType eventType,
                                     @Transform(LocalDateTimeConverter.class) LocalDateTime dateTime) {
        Event event = new Event(title, place, speaker, eventType, dateTime);
        Assert.assertEquals(event, responseEntity.getBody());
    }
}