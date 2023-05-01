package com.sprint.forex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint.forex.entity.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {



	
	@Query("select u from Users u where u.email =:email and u.password=:pwd")
	Optional<Users> login(@Param("email")String email,@Param("pwd") String password);
	
	Optional<Users> findByEmail(String email);
	



}
