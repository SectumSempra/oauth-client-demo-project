package com.sample.oauthsample.model;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MyCustomUserDetails implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4058402420865235575L;

    private Long id;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public MyCustomUserDetails() {
    }

    public MyCustomUserDetails(Long id, String username, String email, String password,
	    Collection<? extends GrantedAuthority> authorities) {
	this.id = id;
	this.username = username;
	this.email = email;
	this.password = password;
	this.authorities = authorities;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
	return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
	this.authorities = authorities;
    }

}
