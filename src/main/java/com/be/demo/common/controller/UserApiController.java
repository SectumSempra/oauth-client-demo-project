package com.be.demo.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.be.demo.common.dto.Users;

//@EnableOAuth2Sso
@Controller
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserApiController {

    @Value("${security.oauth2.resource.user-info-uri}")
    String userInfoUri;

    @Value("${auth-server}")
    String authServer;

    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    @ResponseBody
    Users getUser() {
	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext()
		.getAuthentication().getDetails();
	headers.set("Authorization", "Bearer " + details.getTokenValue()); // accessToken can be the secret key you
									   // generate.
	headers.setContentType(MediaType.APPLICATION_JSON);
	HttpEntity<String> entity = new HttpEntity<>(headers);

	Users users = restTemplate.exchange(userInfoUri, HttpMethod.GET, entity, Users.class).getBody();
	return users;
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Users> createNewUser(@RequestBody Users newUser) {

	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext()
		.getAuthentication().getDetails();
	headers.set("Authorization", "Bearer " + details.getTokenValue()); // accessToken can be the secret key you
									   // generate.
	headers.setContentType(MediaType.APPLICATION_JSON);
	HttpEntity<Users> entity = new HttpEntity<>(newUser,headers);

	String urlUserCreate = authServer + "/api/user/create";
	ResponseEntity<Users> users = restTemplate.exchange(urlUserCreate, HttpMethod.POST, entity, Users.class);

	return users;
    }

}
