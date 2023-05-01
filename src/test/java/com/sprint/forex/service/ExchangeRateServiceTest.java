package com.sprint.forex.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.sprint.forex.dto.ExchangeRateDto;
import com.sprint.forex.entity.Admin;
import com.sprint.forex.entity.ExchangeRate;
import com.sprint.forex.exception.ExchangeRateNotFoundException;
import com.sprint.forex.repository.AdminRepository;
import com.sprint.forex.repository.ExchangeRateRepository;



@SpringBootTest
public class ExchangeRateServiceTest{


	@InjectMocks
	private ExchangeRateServiceImpl exchangeRateService;

	
	@Mock
	private ExchangeRateRepository exchangeRateRepository;

	@InjectMocks
	private AdminServiceImpl adminService = new AdminServiceImpl();

	@Mock
	private AdminRepository adminRepository;

	@Test
	public void testconvertAmount() {
		// Create ExchangeRate instance
		ExchangeRate exchangeRate = new ExchangeRate();
		exchangeRate.setFromCurrency("USD");
		exchangeRate.setToCurrency("EUR");
		exchangeRate.setRate(0.85);

		
		when(exchangeRateRepository.findByFromCurrencyAndToCurrency("USD", "EUR")).thenReturn(exchangeRate);

		// Call the method being tested
		Double convertedAmount = exchangeRateService.convertAmount(100.0, "USD", "EUR");

		
		assertEquals(85.0, convertedAmount, 0.001);

	}

	@Test
	public void testExchangeRateNotFoundException() {
		when(exchangeRateRepository.findById(1)).thenThrow(ExchangeRateNotFoundException.class);
		assertThrows(ExchangeRateNotFoundException.class, () -> exchangeRateService.getById(1));

	}

	@Test
	public void findAllRates() {
		List<ExchangeRate> exchangeRates = new ArrayList<>();
		ExchangeRate exchangeRate1 = new ExchangeRate();
		exchangeRate1.setId(1);
		exchangeRate1.setFromCurrency("EUR");
		exchangeRate1.setToCurrency("INR");
		exchangeRate1.setRate(89.6);
		exchangeRate1.setDate(LocalDate.of(2022, 01, 01));

		ExchangeRate exchangeRate2 = new ExchangeRate();
		exchangeRate2.setId(2);
		exchangeRate2.setFromCurrency("USD");
		exchangeRate2.setToCurrency("GBP");
		exchangeRate2.setRate(99.6);
		exchangeRate2.setDate(LocalDate.of(2022, 01, 02));

		ExchangeRate exchangeRate3 = new ExchangeRate();
		exchangeRate3.setId(3);
		exchangeRate3.setFromCurrency("AED");
		exchangeRate3.setToCurrency("BDT");
		exchangeRate3.setRate(98.2);
		exchangeRate3.setDate(LocalDate.of(2022, 01, 03));

		exchangeRates.add(exchangeRate1);
		exchangeRates.add(exchangeRate2);
		exchangeRates.add(exchangeRate3);

		when(exchangeRateRepository.findAll()).thenReturn(exchangeRates);
		List<ExchangeRate> exchangeRateList = exchangeRateService.findAllRates();
		assertTrue(exchangeRateList.size() == 3);
	}

	@Test
	public void getById() {
		ExchangeRate exchangeRate = new ExchangeRate();
		exchangeRate.setId(1);
		exchangeRate.setFromCurrency("EUR");
		exchangeRate.setToCurrency("INR");
		exchangeRate.setRate(89.6);
		exchangeRate.setDate(LocalDate.of(2022, 01, 01));

		Optional<ExchangeRate> optionalExchangeRate = Optional.of(exchangeRate);
		when(exchangeRateRepository.findById(1)).thenReturn(optionalExchangeRate);

		ExchangeRate exchangeRateObj = exchangeRateService.getById(1);
		assertNotNull(exchangeRateObj.getFromCurrency());
		assertEquals("EUR", exchangeRateObj.getFromCurrency());
		assertEquals("INR", exchangeRateObj.getToCurrency());
	}
}
