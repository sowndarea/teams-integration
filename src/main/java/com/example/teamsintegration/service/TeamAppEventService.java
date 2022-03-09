package com.example.teamsintegration.service;

import com.example.teamsintegration.model.Event;
import com.example.teamsintegration.model.EventFormat;

public interface TeamAppEventService {
	
	EventFormat toGetEvent(String id);

    EventFormat toCreateEvent(Event event);

    void toDeleteEvent(String id);

}
