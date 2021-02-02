package com.be.demo.common.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.be.demo.common.model.Employee;
import com.be.demo.common.services.IEmployeeService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeRestController {

    public static final Logger logger = LoggerFactory.getLogger(EmployeRestController.class);

    @Autowired
    private IEmployeeService eService;

    @GetMapping(value = "/employee-list-all")
    public ResponseEntity<?> listAll() {
	Authentication a = SecurityContextHolder.getContext().getAuthentication();
	System.out.println(a.getName());
	List<Employee> list = eService.listAll();
	return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/employee-list-by-depId/{depId}")
    public ResponseEntity<?> listEmployeByDepId(@PathVariable("depId") Integer depId) {
	List<Employee> list = eService.getAllByDepartmentId(depId);
	return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/employee-list-all-name")
    public ResponseEntity<?> listAllEmployeeNames() {
	List<String> list = eService.getAllNames();
	return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/employee-list-by-name/{name}")
    public ResponseEntity<?> listEmployeByName(@PathVariable("name") String name) {
	List<Employee> list = eService.getByFirstName(name);
	return ResponseEntity.ok(list);
    }

}