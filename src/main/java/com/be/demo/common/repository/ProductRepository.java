package com.be.demo.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.be.demo.common.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
