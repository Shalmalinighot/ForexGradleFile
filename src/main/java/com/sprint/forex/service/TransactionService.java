package com.sprint.forex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.forex.dto.TransactionDto;
import com.sprint.forex.entity.Transaction;

@Service
public interface TransactionService {
   public TransactionDto saveTransaction(TransactionDto transactionDto);
	
	public Transaction getTransactionById(int transactionId);
	
	public TransactionDto findTransactionById(int transactionId);
	
	public List<Transaction> getAllTransactions();
	
	
	
}
