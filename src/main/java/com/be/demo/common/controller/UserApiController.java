package com.be.demo.common.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.be.demo.common.dto.Users;

@EnableOAuth2Sso
@Controller
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserApiController {

	@Value("${auth-server}/api")
	String authServer;

	@Autowired
	@Qualifier("oAuth2RestTemplate")
	public OAuth2RestTemplate oAuth2RestTemplate;

	@RequestMapping(value = "/principal")
	@ResponseBody
	public Principal user(Principal user) {
		return user;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	Users getUser(Principal user) {
		String uri2 = authServer + "/user";
		Users users = oAuth2RestTemplate.getForObject(uri2, Users.class);
		System.err.println("Called api/user" + user.toString());
		return users;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	String getHello(Principal user) {
		return "Hello 84 " + user.getName();
	}

	@RequestMapping(value = "/newuser", method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<Users> createNewUser(@RequestBody Users newUser) {
		String uri2 = authServer + "/user/create";
		ResponseEntity<Users> users = oAuth2RestTemplate.postForEntity(uri2, newUser, Users.class);
		return users;
	}

}
