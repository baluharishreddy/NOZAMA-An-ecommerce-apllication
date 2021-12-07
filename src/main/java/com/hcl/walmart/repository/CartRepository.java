package com.hcl.walmart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.walmart.entity.Cart;
import com.hcl.walmart.entity.MyOrders;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	public List<Cart> findByUserId(int userId);
}
