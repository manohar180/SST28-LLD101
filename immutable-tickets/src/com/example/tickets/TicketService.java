package com.example.tickets;

import java.util.List;

public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {
        return IncidentTicket.builder()
                .id(id)
                .reporterEmail(reporterEmail)
                .title(title)
                .source("CLI")
                .tags(List.of("NEW"))
                .build();
    }

    public IncidentTicket escalateToCritical(IncidentTicket t) {
        return t.toBuilder()
                .priority("CRITICAL")
                .build();
    }

    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {
        return t.toBuilder()
                .assigneeEmail(assigneeEmail)
                .build();
    }
}