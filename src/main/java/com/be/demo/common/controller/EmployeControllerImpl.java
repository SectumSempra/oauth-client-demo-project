package com.be.demo.common.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.be.demo.common.model.Employee;
import com.be.demo.common.services.IEmployeeService;

@RestController
public class EmployeControllerImpl implements EmployeeController {

	public static final Logger logger = LoggerFactory.getLogger(EmployeControllerImpl.class);

	@Autowired
	private IEmployeeService eService;

	@Override
	public ResponseEntity<?> listAll() {
		List<Employee> list = eService.listAll();
		return new ResponseEntity<>(list.subList(0, 10), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> listEmployeByDepId(@PathVariable("depId") Integer depId) {
		List<Employee> list = eService.getAllByDepartmentId(depId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> listAllEmployeeNames() {
		List<String> list = eService.getAllNames();
		return new ResponseEntity<>(list.toArray(new String[list.size()]), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> listEmployeByName(@PathVariable("name") String name) {
		List<Employee> list = eService.getByFirstName(name);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> stuff() {

		return null;
	}

}