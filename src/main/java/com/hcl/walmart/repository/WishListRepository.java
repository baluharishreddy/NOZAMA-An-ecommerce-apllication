package com.hcl.walmart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.walmart.entity.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {

	List<WishList> findByUserId(int userId);

	WishList findByUserIdAndProdId(int userId, int prodId);

}
