package com.arab.banktransfer.controllers;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.arab.banktransfer.entities.ValidateAccount;

@RestController
public class ValidateAccountNumberController {

	@PostMapping(value = "/api/v1/core-banking/validateBankAccount")
	public Object validateAccountNumber(@RequestBody ValidateAccount account) {
		return verifyFromPayStack(account.getAccount_number(), account.getAccount_bank());
	}

	private Object verifyFromFlutterwave(ValidateAccount account) {
		String fToken = "FLWSECK_TEST-148a0343827f5276c49b73fa2e9b8884-X";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + fToken);
		String uri = "https://api.flutterwave.com/v3/accounts/resolve";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> response = restTemplate.exchange(uri, HttpMethod.POST,
				new HttpEntity<>(account, headers), Object.class);

		return response.getBody();
	}

	@PostMapping(value = "/api/v1/core-banking/validateBankAccount/{provider}")
	public Object validateAccountNumber(@PathVariable("provider") String provider,
			@RequestBody ValidateAccount account) {
		switch (provider) {
		case "paystack":
			return verifyFromPayStack(account.getAccount_number(), account.getAccount_bank());
		case "flutter":
			return verifyFromFlutterwave(account);
		default:
			return verifyFromPayStack(account.getAccount_number(), account.getAccount_bank());
		}
	}

	@GetMapping(value = "/api/v1/core-banking/validateBankAccount")
	public Object verifyFromPayStack(String accountNumber, String accountBank) {
		String pToken = "sk_test_a14bf34a2f73ce858166189496b164990c8f4e84";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + pToken);
		String uri = "https://api.paystack.co/bank/resolve?account_number=" + accountNumber + "&bank_code="
				+ accountBank;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> response = restTemplate.exchange(uri, HttpMethod.GET,
				new HttpEntity<>("parameters", headers), Object.class);

		return response.getBody();
	}

}
