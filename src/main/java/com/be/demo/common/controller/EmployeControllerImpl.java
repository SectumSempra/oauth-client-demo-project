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

import com.be.demo.common.model.Employee;
import com.be.demo.common.services.IEmployeeService;

@Controller
public class EmployeControllerImpl implements EmployeeController {

	public static final Logger logger = LoggerFactory.getLogger(EmployeControllerImpl.class);

	@Autowired
	private IEmployeeService eService;

//	@Autowired
//	@Resource(name = "cacheManager")
//	private RedisCacheManager cacheManager;
//
////	@Autowired
//	// @Resource(name = "intKeyRedisTemplate")
//	RedisTemplate<Integer, List<Employee>> intKeyRedisTemplate;
//
//	@Autowired
//	@Resource(name = "intKeyRedisTemplate23")
//	RedisTemplate<Integer, List<Employee>> redisTemplate23;

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
		// cacheable la verilen maneger(yapısı verilen redis temple) onun
		// uzerinden işlem yaptık
//		Cache c = cacheManager.getCache("employees");
//		List<Employee> ll = c.get("listAll", List.class);
//		System.err.println(ll.size());
//
//		Cache c2 = redisCacheManager2.getCache("employeesByDep");
//		ValueWrapper v = c2.get(90);
//		List<Employee> ll2 = c2.get(90, List.class);
//		System.err.println(ll2.size());
//
//		// burda default olan redis tempale inject ettik,onun üstünde işlem
//		// yaptık
//		Boolean b1 = intKeyRedisTemplate.hasKey(90);
//		ListOperations<Integer, List<Employee>> ofl = intKeyRedisTemplate.opsForList();
//		List<Employee> ll3 = ofl.leftPop(33);
//		System.err.println(ll3.size());
//
//		Boolean b2 = redisTemplate23.hasKey(23);
//		ListOperations<Integer, List<Employee>> ofl23 = redisTemplate23.opsForList();
//		List<Employee> ll23 = ofl23.leftPop(23);
//		System.err.println(ll23.size());
		return null;
	}

}