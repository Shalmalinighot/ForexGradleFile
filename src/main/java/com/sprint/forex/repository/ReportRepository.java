package com.sprint.forex.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.forex.entity.Report;


@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
	
}