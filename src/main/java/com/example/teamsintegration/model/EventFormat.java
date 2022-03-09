package com.example.teamsintegration.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class EventFormat {
	private String id;
	private String createdDateTime;
	private String lastModifiedDateTime;
	private String transactionId;
	private String originalStartTimeZone;
	private String originalEndTimeZone;
	private String iCalUId;
	private String reminderMinutesBeforeStart;
	private Boolean isReminderOn;
	private Boolean hasAttachments;
	private String subject;
	private String bodyPreview;
	private String importance;
	private String sensitivity;
	private Boolean isAllDay;
	private Boolean isCancelled;
	private Boolean isOrganizer;
	private Boolean responseRequested;
	private String seriesMasterId;
	private String showAs;
	private String type;
	private String webLink;
	private String onlineMeetingUrl;
	private Boolean isOnlineMeeting;
	private String onlineMeetingProvider;
	private Boolean allowNewTimeProposals;
	private String recurrence;
	private ResponseStatus responseStatus;
	private Body body;
	private Time start;
	private Time end;
	private Location location;
	private List<Location> locations;
	private List<Attendee> attendees;
	private Organizer organizer;
	private OnlineMeetingUrl onlineMeeting;

}
