package com.be.demo.common.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public interface EmployeeController {

	// -------------------Retrieve All
	// Users---------------------------------------------

	@RequestMapping(value = "/country-list-all", method = RequestMethod.GET)
	public ResponseEntity<?> countrylistAll();

	@RequestMapping(value = "/employee-list-all", method = RequestMethod.GET)
	public ResponseEntity<?> listAll();

	@RequestMapping(value = "/employee-list-by-name/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> listEmployeByName(@PathVariable("name") String name);

	@RequestMapping(value = "/employee-list-all-name", method = RequestMethod.GET)
	public ResponseEntity<?> listAllEmployeeNames();

	@RequestMapping(value = "/stuff", method = RequestMethod.GET)
	public ResponseEntity<?> stuff();

	@RequestMapping(value = "/employee-list-by-depId/{depId}", method = RequestMethod.GET)
	public ResponseEntity<?> listEmployeByDepId(@PathVariable("depId") Integer depId);

}