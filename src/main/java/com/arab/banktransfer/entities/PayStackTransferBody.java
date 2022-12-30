package com.arab.banktransfer.entities;


public class PayStackTransferBody {
	
	private TransferRecipient transferRecipient;
	private PayStackTransfer payStackTransfer;
	
	public PayStackTransferBody(TransferRecipient transferRecipient, PayStackTransfer payStackTransfer) {
		super();
		this.transferRecipient = transferRecipient;
		this.payStackTransfer = payStackTransfer;
	}
	/**
	 * @return the recipient
	 */
	public TransferRecipient getRecipient() {
		return transferRecipient;
	}
	/**
	 * @param recipient the recipient to set
	 */
	public void setRecipient(TransferRecipient transferRecipient) {
		this.transferRecipient = transferRecipient;
	}
	
	/**
	 * @return the stackTransfer
	 */
	public PayStackTransfer getStackTransfer() {
		return payStackTransfer;
	}
	/**
	 * @param stackTransfer the stackTransfer to set
	 */
	public void setStackTransfer(PayStackTransfer payStackTransfer) {
		this.payStackTransfer = payStackTransfer;
	}
	
	

}
