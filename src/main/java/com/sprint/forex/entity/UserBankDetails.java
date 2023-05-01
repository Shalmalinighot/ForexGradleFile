package com.sprint.forex.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserBankDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(unique=true)
	private long accountNumber;
	private String accountHolderName;
	private String bankName;
	private String ifscCode;

    private String contactNumber;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private Users user;
    
    public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@OneToMany(mappedBy="userBankDetails")
    private List<Transaction> transaction;

    @JsonIgnore
	public List<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	public String getBankName() {
  		return bankName;
  	}
  	public void setBankName(String bankName) {
  		this.bankName = bankName;
  	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	
	

}
	
	


