package com.example.teamsintegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.teamsintegration.constants.ApplicationConstants;
import com.example.teamsintegration.exception.InvalidInputException;
import com.example.teamsintegration.model.OnlineMeeting;
import com.example.teamsintegration.model.OnlineMeetingFormat;

@Service
public class TeamMeetingServiceImpl implements TeamMeetingService {

	@Autowired
	private RestTemplate template;
	@Autowired
	private ServiceUtil serviceUtil;
	@Autowired
	private OnlineMeetingFormat meeting;

	@Override
	public OnlineMeetingFormat toCreateMeeting(OnlineMeeting meet) {
		try {
			ResponseEntity<OnlineMeetingFormat> response = template.exchange(ApplicationConstants.MEETING_URL,
					HttpMethod.POST, serviceUtil.getHeaderBodyHttpRequest(meet), OnlineMeetingFormat.class);

			meeting = response.getBody();
		} catch (Exception e) {

			throw new InvalidInputException(serviceUtil.errorMessage(e.getMessage()));
		}
		return meeting;
	}

	@Override
	public void toDeleteMeeting(String id) {
		try {
			template.exchange(ApplicationConstants.MEETING_URL + id, HttpMethod.DELETE,
					serviceUtil.getHeaderHttpRequest(), Object.class);
		} catch (Exception e) {

			throw new InvalidInputException(serviceUtil.errorMessage(e.getMessage()));
		}
	}
}
