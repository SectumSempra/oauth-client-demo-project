package com.be.demo.common.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/principal")
    @ResponseBody
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    @ResponseBody
    Users getUser() {
        Users users = restTemplate.getForObject(userInfoUri, Users.class);
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
        ResponseEntity<Users> users = restTemplate.postForEntity(uri2, newUser, Users.class);
        return users;
    }

}
