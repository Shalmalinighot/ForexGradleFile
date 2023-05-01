package com.sprint.forex.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Report{
	
	@Id
    @Column(name="reportId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportId;
	
    private LocalDate TransactionDate;

    @OneToOne
	@JoinColumn(name="transactionId")
	private Transaction transaction;
    
    @Lob
    private byte[] content;
    
    public void setContent(byte[] content) {
        this.content = content;
    }

    public byte[] getContent() {
        return content;
    }
    

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public LocalDate getTransactionDate() {
		return TransactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		TransactionDate = transactionDate;
	}   
}