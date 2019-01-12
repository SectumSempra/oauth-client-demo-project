package com.be.demo.common.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.be.demo.common.model.Country;
import com.be.demo.common.model.Employee;
import com.be.demo.common.services.ICountryService;
import com.be.demo.common.services.IEmployeeService;

@Controller
public class EmployeControllerImpl implements EmployeeController {

	public static final Logger logger = LoggerFactory.getLogger(EmployeControllerImpl.class);

	@Autowired
	private IEmployeeService eService;
	@Autowired
	private ICountryService countryService;

	@Override
	@ResponseBody
	public ResponseEntity<?> countrylistAll() {
		List<Country> list = countryService.listAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Override
	@ResponseBody
	public ResponseEntity<?> listAll() {
		List<Employee> list = eService.listAll();
		return new ResponseEntity<>(list.subList(0, 10), HttpStatus.OK);
	}

	@ResponseBody
	public ResponseEntity<?> listEmployeByDepId(@PathVariable("depId") Integer depId) {
		List<Employee> list = eService.getAllByDepartmentId(depId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Override
	@ResponseBody
	public ResponseEntity<?> listAllEmployeeNames() {
		List<String> list = eService.getAllNames();
		return new ResponseEntity<>(list.toArray(new String[list.size()]), HttpStatus.OK);
	}

	@ResponseBody
	public ResponseEntity<?> listEmployeByName(@PathVariable("name") String name) {
		List<Employee> list = eService.getByFirstName(name);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Override
	@ResponseBody
	public ResponseEntity<?> stuff() {

		return null;
	}

}