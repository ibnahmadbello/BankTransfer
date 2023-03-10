package com.arab.banktransfer.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.arab.banktransfer.entities.BankTransfer;
import com.arab.banktransfer.entities.InitiateTransfer;
import com.arab.banktransfer.entities.PayStackTransfer;
import com.arab.banktransfer.entities.PayStackTransferBody;
import com.arab.banktransfer.entities.TransferRecipient;

@EnableAutoConfiguration
@RestController
public class TransferController {
	
	private ArrayList<String> listOfReference = new ArrayList<>();
	
	@PostMapping("/api/v1/core-banking/bankTransfer")
	public String bankTransfer(@RequestBody BankTransfer bankTransfer) {
		return transferViaFlutter(bankTransfer);
	}
	

	@PostMapping("/api/v1/core-banking/bankTransfer/flutter")
	private String transferViaFlutter(BankTransfer bankTransfer) {
		String fToken = "FLWSECK_TEST-148a0343827f5276c49b73fa2e9b8884-X";
		String reference = generateTransferReference();
		while(listOfReference.contains(reference)) {
			reference = generateTransferReference();
		} 
		listOfReference.add(reference);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + fToken);
		headers.add("idempotency-key", reference);
		String uri = "https://api.flutterwave.com/v3/transfers";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST,
				new HttpEntity<>(bankTransfer, headers), String.class);

		return response.getBody().toString();
	}
	
	@PostMapping("/createtransferrecipient")
	private String createTransferRecipient(@RequestBody TransferRecipient recipient) {
		String pToken = "sk_test_a14bf34a2f73ce858166189496b164990c8f4e84";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + pToken);
		String uri = "https://api.paystack.co/transferrecipient";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST,
				new HttpEntity<>(recipient, headers), String.class);

		return response.getBody().toString();
	}
	
	private String generateTransferReference() {
		UUID uuid = UUID.randomUUID();
		String reference = uuid.toString();
		return reference;
	}
	
	@PostMapping("/api/v1/core-banking/bankTransfer/paystack")
	public String transferViaPayStack(@RequestBody PayStackTransferBody body) {
		PayStackTransfer payStackTransfer = body.getStackTransfer();
		
		TransferRecipient transferRecipient = body.getRecipient();
		System.out.println(transferRecipient);
		
		String recipientResponse = createTransferRecipient(transferRecipient);
		int index = recipientResponse.indexOf("RCP");
		String recipient = recipientResponse.substring(index, index+20);
		
		String reference = generateTransferReference();
		while(listOfReference.contains(reference)) {
			reference = generateTransferReference();
		} 
		listOfReference.add(reference);
		
		InitiateTransfer transfer = new InitiateTransfer(payStackTransfer, recipient, reference);
		String pToken = "sk_test_a14bf34a2f73ce858166189496b164990c8f4e84";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + pToken);
		headers.add("idempotency-key", reference);
		String uri = "https://api.paystack.co/transfer";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST,
				new HttpEntity<>(transfer, headers), String.class);

		return response.getBody().toString();
	}

}
