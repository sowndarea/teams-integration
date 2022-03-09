package com.example.teamsintegration.model;

import lombok.Data;

@Data
public class Token {
	private String token_type;
	private String expires_in;
	private String ext_expires_in;
	private String access_token;

}
