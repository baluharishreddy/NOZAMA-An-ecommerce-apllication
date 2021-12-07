package com.hcl.walmart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.walmart.entity.MyOrders;

@Repository
public interface BuyRepository extends JpaRepository<MyOrders, Integer> {

	List<MyOrders> findByUserId(int userId);

}
