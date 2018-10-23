package com.be.demo.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.be.demo.common.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> getByFirstName(String firstName);

    @Query("select distinct e.firstName from Employee e")
    List<String> getAllNames();

    List<Employee> getByDepartmentId(Integer departmentId);

}
