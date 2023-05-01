package com.sprint.forex.dto;



public class UserBankDetailsDto {
	 private int userBankId;
	 private String accountHolderName;
	 private String bankName;
	 private String IfscCode;
	 private Long accountNumber;
	 private String contactnumber;
	 private int userId;
	public int getUserBankId() {
		return userBankId;
	}
	public void setUserBankId(int userBankId) {
		this.userBankId = userBankId;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfscCode() {
		return IfscCode;
	}
	public void setIfscCode(String ifscCode) {
		IfscCode = ifscCode;
	}
	
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long i) {
		this.accountNumber = i;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	 
	 

}
