package com.hcl.walmart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.walmart.entity.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {

	public List<Register> findByUserName(String userName);

}
