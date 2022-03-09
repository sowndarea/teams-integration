package com.example.teamsintegration.model;

import java.util.List;

import lombok.Data;

@Data
public class Event {
	private String subject;
	private Body body;
	private Time start;
	private Time end;
	private Location location;
	private List<Attendee> attendees;
	private Boolean allowNewTimeProposals;
	private Boolean isOnlineMeeting;
	private String onlineMeetingProvider;

}
