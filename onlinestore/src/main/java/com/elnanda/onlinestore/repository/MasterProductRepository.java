package com.elnanda.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elnanda.onlinestore.model.MasterProduct;

public interface MasterProductRepository extends JpaRepository<MasterProduct, Integer> {

}
