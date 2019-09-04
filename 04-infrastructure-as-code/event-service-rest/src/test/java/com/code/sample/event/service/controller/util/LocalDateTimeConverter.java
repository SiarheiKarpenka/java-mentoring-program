package com.code.sample.event.service.controller.util;

import java.time.LocalDateTime;

import cucumber.api.Transformer;

import java.time.format.DateTimeFormatter;

public class LocalDateTimeConverter extends Transformer<LocalDateTime> {

    private static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public LocalDateTime transform(String value) {
        return LocalDateTime.parse(value, DEFAULT_DATE_FORMATTER);
    }
}
