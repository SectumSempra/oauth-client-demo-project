package com.be.demo.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.be.demo.common.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
