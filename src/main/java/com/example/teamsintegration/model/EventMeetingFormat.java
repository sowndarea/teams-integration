package com.example.teamsintegration.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class EventMeetingFormat {
    private String id;
    private Boolean isOnlineMeeting;
    private String onlineMeetingProvider;
    private OnlineMeetingUrl onlineMeeting;
}
