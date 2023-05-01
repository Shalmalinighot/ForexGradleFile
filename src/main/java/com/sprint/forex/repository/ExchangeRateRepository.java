package com.sprint.forex.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.forex.entity.ExchangeRate;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate,Integer>{

	ExchangeRate save(ExchangeRate exchangeRate);

	ExchangeRate findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
	

	List<ExchangeRate> findByDate(LocalDate date);
	
//	To get rates by providing from currency and to currency

	List<ExchangeRate> findByFromCurrencyAndToCurrencyAndDate(String fromCurrency, String toCurrency, LocalDate date);
	

}