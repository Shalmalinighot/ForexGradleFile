package com.sprint.forex.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Transaction {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionId")
	 private int transactionId;
    
    @Column(name="FromCountry")
    private String fromCountry;
    
    @Column(name="ToCountry")
    private String toCountry;
    
    @Column(name="SenderName")
    private String senderName;
    
    @Column(name="ReceiverName")
    private String receiverName;
    
    @Column(name="SenderAccNo")
    private long senderAccNo;
    
    @Column(name="ReceiverAccNo")
    private long receiverAccNo;
    
    @Column(name="SendingCurrency")
    private String sendingCurrency;
    
    @Column(name="ReceivingCurrency")
    private String receivingCurrency;
    
    @Column(name="SendingAmount")
    private long sendingAmount;
    
    private double totalAmount;
    
    private LocalDate transactionDate;
    
    @Lob
    private byte[] fileContents;
    
public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public byte[] getFileContents() {
		return fileContents;
	}

	public void setFileContents(byte[] fileContents) {
		this.fileContents = fileContents;
	}

public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	//    @OneToOne
//    @JoinColumn(name="userId")
//    private User user;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="bankId")
    private UserBankDetails userBankDetails;

	

	

	public UserBankDetails getUserBankDetails() {
		return userBankDetails;
	}

	public void setUserBankDetails(UserBankDetails userBankDetails) {
		this.userBankDetails = userBankDetails;
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

	
	
    
    
    
}
