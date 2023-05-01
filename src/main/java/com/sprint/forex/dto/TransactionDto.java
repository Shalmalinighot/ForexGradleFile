package com.sprint.forex.dto;

import java.time.LocalDate;

import com.sprint.forex.entity.Transaction;

public class TransactionDto {

	private int transactionId;

	private String fromCountry;

	private String toCountry;

	private String senderName;

	private String receiverName;

	private long senderAccNo;

	private long receiverAccNo;

	private String sendingCurrency;

	private String receivingCurrency;

	private long sendingAmount;

	private LocalDate transactionDate;

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getFromCountry() {
		return fromCountry;
	}

	public void setFromCountry(String fromCountry) {
		this.fromCountry = fromCountry;
	}

	public String getToCountry() {
		return toCountry;
	}

	public void setToCountry(String toCountry) {
		this.toCountry = toCountry;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public long getSenderAccNo() {
		return senderAccNo;
	}

	public void setSenderAccNo(long senderAccNo) {
		this.senderAccNo = senderAccNo;
	}

	public long getReceiverAccNo() {
		return receiverAccNo;
	}

	public void setReceiverAccNo(long receiverAccNo) {
		this.receiverAccNo = receiverAccNo;
	}

	public String getSendingCurrency() {
		return sendingCurrency;
	}

	public void setSendingCurrency(String sendingCurrency) {
		this.sendingCurrency = sendingCurrency;
	}

	public String getReceivingCurrency() {
		return receivingCurrency;
	}

	public void setReceivingCurrency(String receivingCurrency) {
		this.receivingCurrency = receivingCurrency;
	}

	public long getSendingAmount() {
		return sendingAmount;
	}

	public void setSendingAmount(long sendingAmount) {
		this.sendingAmount = sendingAmount;
	}
	
	public TransactionDto(Transaction transaction) {
		 this.transactionId = transaction.getTransactionId();
		 this.transactionDate = transaction.getTransactionDate();
		 this.fromCountry = transaction.getFromCountry();
		 this.toCountry = transaction.getToCountry();
		 this.senderName = transaction.getSenderName();
		 this.receiverName = transaction.getReceiverName();
		 this.senderAccNo = transaction.getSenderAccNo();
		 this.receiverAccNo = transaction.getReceiverAccNo();
		 this.sendingCurrency = transaction.getSendingCurrency();
		 this.receivingCurrency = transaction.getReceivingCurrency();
		 this.sendingAmount = transaction.getSendingAmount();
		 }

		public TransactionDto() {
		 // Default constructor
		}

}
