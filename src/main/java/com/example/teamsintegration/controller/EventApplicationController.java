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
import com.example.teamsintegration.service.TeamAppEventService;

@RestController
public class EventApplicationController {

	@Autowired
	private TeamAppEventService teamAppEventService;

	@GetMapping("/getappevent/{id}")
	public ResponseEntity<EventFormat> getEvent(@PathVariable String id) {

		return new ResponseEntity<>(teamAppEventService.toGetEvent(id), HttpStatus.OK);

	}

	@PostMapping("/createappevent")
	public ResponseEntity<EventFormat> createEvent(@RequestBody Event event) {

		return new ResponseEntity<>(teamAppEventService.toCreateEvent(event), HttpStatus.CREATED);

	}
	
	 @DeleteMapping("/deleteappevent/{id}")
	    public ResponseEntity<Object> deleteMeeting(@PathVariable String id){

		 teamAppEventService.toDeleteEvent(id);
	        return  new ResponseEntity<>( HttpStatus.NO_CONTENT);

	    }

}
