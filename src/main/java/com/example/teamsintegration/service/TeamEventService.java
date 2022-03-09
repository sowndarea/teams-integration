package com.example.teamsintegration.service;

import com.example.teamsintegration.model.*;

public interface TeamEventService {
    EventFormat toGetEvent(String id);

    EventFormat toCreateEvent(Event event);

    void toDeleteEvent(String id);
}
