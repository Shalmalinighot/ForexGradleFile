package com.sprint.forex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.forex.entity.Verification;

@Repository
public interface VerificationRepository extends JpaRepository< Verification,Integer> {

	public Optional<Verification> findByUserName(String userName);
	public void deleteByUserName(String userName);
	
}

