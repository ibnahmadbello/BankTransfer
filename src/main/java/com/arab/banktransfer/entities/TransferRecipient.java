package com.arab.banktransfer.entities;

public class TransferRecipient {

	private String type;
    private String name;
    private String account_number;
    private String bank_code;
    private String currency;
    
	public TransferRecipient(String type, String name, String account_number, String bank_code, String currency) {
		super();
		this.type = type;
		this.name = name;
		this.account_number = account_number;
		this.bank_code = bank_code;
		this.currency = currency;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the bank_code
	 */
	public String getBank_code() {
		return bank_code;
	}

	/**
	 * @param bank_code the bank_code to set
	 */
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "TransferRecipient [type=" + type + ", name=" + name + ", account_number=" + account_number
				+ ", bank_code=" + bank_code + ", currency=" + currency + "]";
	}


	
    
}
