package com.example.teamsintegration.controller;

import com.example.teamsintegration.model.OnlineMeeting;
import com.example.teamsintegration.model.OnlineMeetingFormat;
import com.example.teamsintegration.service.TeamMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MeetingController {
    @Autowired
    private TeamMeetingService teamMeetingService;
    @PostMapping("/createmeeting")

    public ResponseEntity<OnlineMeetingFormat> createMeeting(@RequestBody OnlineMeeting meet) {

        return new ResponseEntity<> (teamMeetingService.toCreateMeeting(meet), HttpStatus.CREATED);

    }
    @DeleteMapping("/deletemeeting/{id}")
    public ResponseEntity<Object> deleteMeeting(@PathVariable String id){

        teamMeetingService.toDeleteMeeting(id);
        return  new ResponseEntity<>( HttpStatus.NO_CONTENT);

    }
}
