package com.be.demo.common.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.be.demo.common.cahce.DemoCacheUtils;
import com.be.demo.common.model.Employee;
import com.be.demo.common.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository ep;

	@Cacheable(cacheNames = DemoCacheUtils.CN_EMPLOYEE, cacheManager = DemoCacheUtils.CN_CACHEMANAGER, keyGenerator = "keyGeneratorV2")
	@Override
	public List<Employee> listAll() {
		return ep.findAll();
	}

	@Override
	public List<Employee> getByFirstName(String firstName) {
		return ep.getByFirstName(firstName);
	}

	@Override
	public List<String> getAllNames() {
		return ep.getAllNames();
	}

	@Override
	public List<Employee> getAllByDepartmentId(Integer departmentId) {
		return ep.getByDepartmentId(departmentId);
	}

	@Override
	public void save(Employee emp) {
		ep.save(emp);
	}

}
