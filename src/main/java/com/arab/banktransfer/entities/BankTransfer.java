package com.arab.banktransfer.entities;

public class BankTransfer {

	private String account_bank;
    private String account_number;
    private double amount;
    private String narration;
    private String currency;
    private String reference;
    private String callback_url;
    private String debit_currency;
    
    
	public BankTransfer(String account_bank, String account_number, double amount, String narration, String currency,
			String reference, String callback_url, String debit_currency) {
		super();
		this.account_bank = account_bank;
		this.account_number = account_number;
		this.amount = amount;
		this.narration = narration;
		this.currency = currency;
		this.reference = reference;
		this.callback_url = callback_url;
		this.debit_currency = debit_currency;
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
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the narration
	 */
	public String getNarration() {
		return narration;
	}
	/**
	 * @param narration the narration to set
	 */
	public void setNarration(String narration) {
		this.narration = narration;
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
	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}
	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}
	/**
	 * @return the callback_url
	 */
	public String getCallback_url() {
		return callback_url;
	}
	/**
	 * @param callback_url the callback_url to set
	 */
	public void setCallback_url(String callback_url) {
		this.callback_url = callback_url;
	}
	/**
	 * @return the debit_currency
	 */
	public String getDebit_currency() {
		return debit_currency;
	}
	/**
	 * @param debit_currency the debit_currency to set
	 */
	public void setDebit_currency(String debit_currency) {
		this.debit_currency = debit_currency;
	}
	@Override
	public String toString() {
		return "BankTransfer [account_bank=" + account_bank + ", account_number=" + account_number + ", amount="
				+ amount + ", narration=" + narration + ", currency=" + currency + ", reference=" + reference
				+ ", callback_url=" + callback_url + ", debit_currency=" + debit_currency + "]";
	}
    
    
}
