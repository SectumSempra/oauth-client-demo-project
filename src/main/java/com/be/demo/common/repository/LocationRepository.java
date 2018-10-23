package com.be.demo.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.be.demo.common.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
