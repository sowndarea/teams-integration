package com.example.teamsintegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.teamsintegration.constants.ApplicationConstants;
import com.example.teamsintegration.exception.InvalidInputException;
import com.example.teamsintegration.model.Token;

@Service
public class ApplicationService {

	@Autowired
	private RestTemplate template;
	@Autowired
	private HttpHeaders headers;
	@Autowired
	private ServiceUtil serviceUtil;

	@Value("${teams.client_id}")
	private String client_id;
	@Value("${teams.scope}")
	private String scope;
	@Value("${teams.client_secret}")
	private String client_secret;
	@Value("${teams.grant_type}")
	private String grant_type;
	@Value("${teams.tenant_id}")
	private String tenantId;

	public String getApplicationToken() {

		String token;
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("client_id", client_id);
		map.add("scope", scope);
		map.add("client_secret", client_secret);
		map.add("grant_type", grant_type);
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
		try {
			ResponseEntity<Token> response = template.exchange(
					ApplicationConstants.LOGIN_URL + tenantId + ApplicationConstants.OAUTH_END_POINT, HttpMethod.POST,
					entity, Token.class);
			token = response.getBody().getAccess_token();

		} catch (Exception e) {

			throw new InvalidInputException(serviceUtil.errorMessage(e.getMessage()));
		}

		return token;

	}
}
