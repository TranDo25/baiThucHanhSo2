package com.nhom5.product.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhom5.product.management.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
