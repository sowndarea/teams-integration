package com.example.teamsintegration.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class OnlineMeetingFormat {

    private AudioConferencing audioConferencing;
    private ChatInfo chatInfo;
    private String creationDateTime;
    private String startDateTime;
    private String id;
    private String joinWebUrl;
    private Participants participants;
    private String subject;


}
