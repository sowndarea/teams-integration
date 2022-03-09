package com.example.teamsintegration.service;

import com.example.teamsintegration.constants.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ServiceUtil {

	@Value("${teams.user.token}")
	private String token;

	@Autowired
	private HttpHeaders headers;

	public HttpEntity<String> getHeaderHttpRequest() {
		headers.set(ApplicationConstants.AUTHORIZATION, ApplicationConstants.BEARER + token);
		return new HttpEntity<>(headers);

	}

	public <T> HttpEntity<T> getHeaderBodyHttpRequest(T t) {
		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		header.add(ApplicationConstants.AUTHORIZATION, ApplicationConstants.BEARER + token);
		header.add("Content-Type", "application/json");
		return new HttpEntity<>(t, header);

	}

	public HttpEntity<String> getHeaderHttpRequest(String userToken) {
		headers.set(ApplicationConstants.AUTHORIZATION, ApplicationConstants.BEARER + userToken);
		return new HttpEntity<>(headers);

	}

	public <T> HttpEntity<T> getHeaderBodyHttpRequest(T t, String userToken) {
		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		header.add(ApplicationConstants.AUTHORIZATION, ApplicationConstants.BEARER + userToken);
		header.add("Content-Type", "application/json");
		return new HttpEntity<>(t, header);

	}

	public String errorMessage(String msg) {

		String val = "";
		Pattern p = Pattern.compile("\"message\":(.*)");
		Matcher m = p.matcher(msg);

		if (m.find()) {
			String desc = m.group(1);
			p = Pattern.compile("\"(.*)");
			m = p.matcher(desc);
			if (m.find()) {
				String temp = m.group(1);
				val = temp.substring(0, temp.length() - 2);
			}
		}
		return val;

	}
}
