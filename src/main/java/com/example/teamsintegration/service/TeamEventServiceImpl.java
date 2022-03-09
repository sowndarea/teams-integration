package com.example.teamsintegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.teamsintegration.constants.ApplicationConstants;
import com.example.teamsintegration.exception.InvalidInputException;
import com.example.teamsintegration.model.Event;
import com.example.teamsintegration.model.EventFormat;

@Service
public class TeamEventServiceImpl implements TeamEventService {
	@Value("${teams.user.token}")
	private	 String token;
	@Autowired
	private RestTemplate template;
	@Autowired
	private ServiceUtil serviceUtil;
	@Autowired
	private EventFormat eventFormat;

	@Override
	public EventFormat toGetEvent(String id) {
		try {

			ResponseEntity<EventFormat> response = template.exchange(ApplicationConstants.EVENT_URL + id,
					HttpMethod.GET, serviceUtil.getHeaderHttpRequest(token), EventFormat.class);

			eventFormat = response.getBody();
		} catch (Exception e) {

			throw new InvalidInputException(serviceUtil.errorMessage(e.getMessage()));
		}
		return eventFormat;
	}

	@Override
	public EventFormat toCreateEvent(Event event) {
		try {
			ResponseEntity<EventFormat> response = template.exchange(ApplicationConstants.EVENT_URL, HttpMethod.POST,
					serviceUtil.getHeaderBodyHttpRequest(event), EventFormat.class);
			eventFormat = response.getBody();
		} catch (Exception e) {

			throw new InvalidInputException(serviceUtil.errorMessage(e.getMessage()));
		}
		return eventFormat;
	}

	@Override
	public void toDeleteEvent(String id) {
		try {
			template.exchange(ApplicationConstants.EVENT_URL + id, HttpMethod.DELETE,
					serviceUtil.getHeaderHttpRequest(), Object.class);
		} catch (Exception e) {

			throw new InvalidInputException(serviceUtil.errorMessage(e.getMessage()));
		}

	}

}
