package com.code.sample.markdown;

import java.util.List;
import java.util.stream.Collectors;

public class MarkdownService {

    /**
     * Format List
     *
     * @param events {@link List} of Events
     * @return {@link String} representing formatted list of Events
     */
    public String formatList(List<String> events) {
        return events.stream()
                .map((e) -> "* " + e)
                .collect(Collectors.joining("\n"));
    }
}
