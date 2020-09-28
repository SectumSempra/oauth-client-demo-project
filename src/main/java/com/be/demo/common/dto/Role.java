package com.be.demo.common.dto;

import java.io.Serializable;

public class Role implements Serializable {
    private static final long serialVersionUID = -8388144719145840813L;

    private int roleId;

    private String role;

    public Role() {
    }

    public int getRoleId() {
	return roleId;
    }

    public void setRoleId(int roleId) {
	this.roleId = roleId;
    }

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }
}
