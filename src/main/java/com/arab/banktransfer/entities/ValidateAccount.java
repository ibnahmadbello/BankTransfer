package com.arab.banktransfer.entities;

public class ValidateAccount {
	
	private String account_number;
	private String account_bank;
	
	public ValidateAccount() {}
	
	public ValidateAccount(String account_number, String account_bank) {
		this.account_number = account_number;
		this.account_bank = account_bank;
	}

	/**
	 * @return the account_number
	 */
	public String getAccount_number() {
		return account_number;
	}

	/**
	 * @param account_number the account_number to set
	 */
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	/**
	 * @return the account_bank
	 */
	public String getAccount_bank() {
		return account_bank;
	}

	/**
	 * @param account_bank the account_bank to set
	 */
	public void setAccount_bank(String account_bank) {
		this.account_bank = account_bank;
	}

	@Override
	public String toString() {
		return "ValidateAccount [account_number=" + account_number + ", account_bank=" + account_bank + "]";
	}

}
