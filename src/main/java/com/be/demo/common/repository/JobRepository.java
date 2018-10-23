package com.be.demo.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.be.demo.common.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {

}
