package com.hcl.walmart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.walmart.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	public Product findByProdId(int prodId);

	public List<Product> findByCatId(int catId);

}
