package com.be.demo.common.services;

import java.util.List;

import com.be.demo.common.model.Employee;

public interface IEmployeeService {

    public List<Employee> listAll();

    public List<Employee> getByFirstName(String firstName);

    public List<String> getAllNames();

    public List<Employee> getAllByDepartmentId(Integer departmentId);

}
