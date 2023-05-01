package com.sprint.forex.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.forex.entity.Transaction;
import com.sprint.forex.exception.TransactionNotFoundException;
import com.sprint.forex.repository.TransactionRepository;

@SpringBootTest
public class TransactionServiceTest {

	@InjectMocks
    private TransactionServiceImpl transactionService;
	
	@Mock
	private TransactionRepository transactionRepository;

	@Test
	public void testTransactionById() {
		Transaction transaction = new Transaction();
		transaction.setTransactionId(1);
        transaction.setFromCountry("USA");
        transaction.setToCountry("India");
		transaction.setSenderName("misba");
		transaction.setReceiverName("priya");
		transaction.setSenderAccNo(123456);
		transaction.setReceiverAccNo(898989);
		transaction.setSendingCurrency("USD");
		transaction.setReceivingCurrency("INR");
		transaction.setTotalAmount(80.0);
		transaction.setTransactionDate(LocalDate.of(2023, 04, 16));

		Optional<Transaction> optionalTransaction = Optional.of(transaction);
		when(transactionRepository.findById(1)).thenReturn(optionalTransaction);

		Transaction transactionObj = transactionService.getTransactionById(1);

		assertEquals("USA", transactionObj.getFromCountry());

		assertEquals("India", transactionObj.getToCountry());
		assertNotNull(transactionObj.getReceiverAccNo());
		assertNotSame(transactionObj.getFromCountry(), transactionObj.getToCountry());
	}

	@Test
	public void testGetTransactionByIdException() {

		when(transactionRepository.findById(1)).thenThrow(TransactionNotFoundException.class);

		assertThrows(TransactionNotFoundException.class, () -> transactionService.getTransactionById(1));
	}

	@Test
	void testGetAllTransaction() {

		List<Transaction> transaction = new ArrayList<>();

		Transaction transaction1 = new Transaction();
		transaction1.setTransactionId(1);
        transaction1.setFromCountry("USA");
        transaction1.setToCountry("India");
		transaction1.setSenderName("misba");
		transaction1.setReceiverName("priya");
		transaction1.setSenderAccNo(123456);
		transaction1.setReceiverAccNo(898989);
		transaction1.setSendingCurrency("USD");
		transaction1.setReceivingCurrency("INR");
		transaction1.setTotalAmount(80.0);
		transaction1.setTransactionDate(LocalDate.of(2023, 04, 16));

		Transaction transaction2 = new Transaction();
		transaction2.setTransactionId(2);
        transaction2.setFromCountry("EUR");
        transaction2.setToCountry("India");
		transaction2.setSenderName("riya");
		transaction2.setReceiverName("neha");
		transaction2.setSenderAccNo(909090);
		transaction2.setReceiverAccNo(555555);
		transaction2.setSendingCurrency("EUR");
		transaction2.setReceivingCurrency("INR");
		transaction2.setTotalAmount(1000.0);
		transaction2.setTransactionDate(LocalDate.of(2023, 03, 16));

		transaction.add(transaction2);
		transaction.add(transaction1);

		when(transactionRepository.findAll()).thenReturn(transaction);

		List<Transaction> transactionList = transactionService.getAllTransactions();

		assertEquals(2, transactionList.size());
		
	}

}
