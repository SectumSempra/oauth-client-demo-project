package com.be.demo.common.dto;

import java.io.Serializable;
import java.util.Set;

public class Users implements Serializable {
    private long id;

    private String email;

    private String name;
    private String password;
    private String lastName;
    private int active;

    private Set<Role> roles;

    public Users() {
    }

    public Users(Users users) {

	this.active = users.active;
	this.email = users.email;
	this.id = users.id;
	this.lastName = users.lastName;
	this.name = users.name;
	this.password = users.password;
	this.roles = users.roles;

    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public int getActive() {
	return active;
    }

    public void setActive(int active) {
	this.active = active;
    }

    public Set<Role> getRoles() {
	return roles;
    }

    public void setRoles(Set<Role> roles) {
	this.roles = roles;
    }
}
