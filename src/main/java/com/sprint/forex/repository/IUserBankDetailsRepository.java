package com.sprint.forex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.forex.entity.UserBankDetails;
import com.sprint.forex.entity.Users;

@Repository
public interface IUserBankDetailsRepository extends JpaRepository<UserBankDetails,Integer> {
	 Optional<UserBankDetails> findByAccountNumber(long accountNumber);
	 
}

