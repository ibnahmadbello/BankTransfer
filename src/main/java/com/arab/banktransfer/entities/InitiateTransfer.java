package com.arab.banktransfer.entities;

public class InitiateTransfer {
	private PayStackTransfer payStackTransfer;
	private String recipient;
	private String reference;
	
	public InitiateTransfer(PayStackTransfer payStackTransfer, String recipient, String reference) {
		super();
		this.payStackTransfer = payStackTransfer;
		this.recipient = recipient;
		this.reference = reference;
	}
	/**
	 * @return the payStackTransfer
	 */
	public PayStackTransfer getPayStackTransfer() {
		return payStackTransfer;
	}
	/**
	 * @param payStackTransfer the payStackTransfer to set
	 */
	public void setPayStackTransfer(PayStackTransfer payStackTransfer) {
		this.payStackTransfer = payStackTransfer;
	}
	/**
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipient;
	}
	/**
	 * @param recipient the recipient to set
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
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
	
	
	
}
