package com.sprint.forex.dto;

import java.time.LocalDate;
import com.sprint.forex.entity.Transaction;

public class ReportDto {
	
	private int reportId;

	private TransactionDto transactionDto;
	
	private Transaction transactionId;

	private LocalDate transactionDate;

	public Transaction getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Transaction transactionId) {
		this.transactionId = transactionId;
	}

	public TransactionDto getTransactionDto() {
		return transactionDto;
	}

	public void setTransactionDto(TransactionDto transactionDto) {
		this.transactionDto = transactionDto;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		transactionDate = transactionDate;
	}
}
    



