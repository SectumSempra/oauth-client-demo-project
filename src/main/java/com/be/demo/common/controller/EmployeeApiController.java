package com.be.demo.common.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.be.demo.common.model.Employee;
import com.be.demo.common.repository.EmployeeRepository;

/**
 * @author beraslan xpai path alındakiler aouth a takılamadan dışarı
 *         açılabilimektedir
 */
@RestController
@RequestMapping("/xapi")
public class EmployeeApiController {

	@Autowired
	EmployeeRepository ep;

	@ResponseBody
	@GetMapping(value = "/employeeX-list-all/", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Employee> listAll(Principal principal) {
		return ep.findAll();
	}

	@ResponseBody
	@GetMapping(value = "/employeeX-list-by-name/{name}", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Employee> listEmployeByName(Principal principal, @PathVariable("name") String name) {
		return ep.getByFirstName(name);
	}

	@ResponseBody
	@GetMapping(value = "/employeeX-list-all-name", produces = MediaType.APPLICATION_XML_VALUE)
	public List<String> listAllEmployeeNames(Principal principal) {
		return ep.getAllNames();
	}

}