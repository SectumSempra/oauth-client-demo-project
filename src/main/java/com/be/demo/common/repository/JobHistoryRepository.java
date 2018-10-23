package com.be.demo.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.be.demo.common.model.JobHistory;
import com.be.demo.common.model.JobHistoryPK;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryPK> {

}
