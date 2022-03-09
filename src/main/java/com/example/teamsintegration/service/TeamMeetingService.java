package com.example.teamsintegration.service;

import com.example.teamsintegration.model.OnlineMeeting;
import com.example.teamsintegration.model.OnlineMeetingFormat;

public interface TeamMeetingService {
    OnlineMeetingFormat toCreateMeeting(OnlineMeeting meet);

    void toDeleteMeeting(String id);
}
