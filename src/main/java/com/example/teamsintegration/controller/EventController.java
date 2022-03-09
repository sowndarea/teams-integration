package com.example.teamsintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.teamsintegration.model.Event;
import com.example.teamsintegration.model.EventFormat;
import com.example.teamsintegration.service.TeamEventService;

@RestController
public class EventController {
	@Autowired
	private TeamEventService teamEventService;

	@GetMapping("/getevent/{id}")
	public ResponseEntity<EventFormat> getEvent(@PathVariable String id) {

		return new ResponseEntity<>(teamEventService.toGetEvent(id), HttpStatus.OK);

	}

	@PostMapping("/createevent")

	public ResponseEntity<EventFormat> createEvent(@RequestBody Event event) {

		return new ResponseEntity<>(teamEventService.toCreateEvent(event), HttpStatus.CREATED);

	}
	 @DeleteMapping("/deleteevent/{id}")
	    public ResponseEntity<Object> deleteMeeting(@PathVariable String id){

		 teamEventService.toDeleteEvent(id);
	        return  new ResponseEntity<>( HttpStatus.NO_CONTENT);

	    }

}
