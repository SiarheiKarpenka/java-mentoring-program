package com.code.sample;

import com.code.sample.event.service.EventService;
import com.code.sample.markdown.MarkdownService;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class EventServiceClient {

    private static List<EventService> eventServices = new ArrayList<>();

    private static MarkdownService markdownService = new MarkdownService();

    public static void main(String[] args) {
        System.out.println("\nEvent Service Schedule");
        System.out.println("========================");

        ServiceLoader.load(EventService.class).forEach(eventServices::add);

        List<String> events = new ArrayList<>();

        eventServices.stream()
                .map(EventService::getEvents)
                .forEach(events::addAll);

        System.out.println(markdownService.formatList(events));
    }
}
