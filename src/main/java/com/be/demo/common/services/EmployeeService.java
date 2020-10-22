package com.be.demo.common.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.be.demo.common.cahce.MyCacheUtils;
import com.be.demo.common.model.Employee;
import com.be.demo.common.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository ep;

    @Cacheable(cacheNames = MyCacheUtils.CN_EMPLOYEE, cacheManager = MyCacheUtils.CacheBeans.CACHE_MANAGER, keyGenerator = MyCacheUtils.CacheBeans.KEY_GENERATOR)
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
