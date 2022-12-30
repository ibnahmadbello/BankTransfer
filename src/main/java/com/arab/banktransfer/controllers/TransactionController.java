package com.arab.banktransfer.controllers;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TransactionController {

	@GetMapping(value = "/api/v1/core-banking/transaction/{provider}/{transactionId}")
	public String verifyTransaction(@PathVariable(name = "provider", required = false) String provider,
			@PathVariable String transactionId) {
		switch (provider) {
		case "paystack":
			return verifyTransactionFromPayStack(transactionId);
		case "flutter":
			return verifyTransactionFromFlutter(Integer.parseInt(transactionId));
		default:
			return verifyTransactionFromFlutter(Integer.parseInt(transactionId));
		}
	}

	@GetMapping(value = "/api/v1/core-banking/transaction/{transactionId}")
	public String verifyTransaction(@PathVariable String transactionId) {
		return verifyTransactionFromFlutter(Integer.parseInt(transactionId));
	}

	//@GetMapping(value = "/api/v1/core-banking/transaction/{transactionId}")
	public String verifyTransactionFromFlutter(@PathVariable("transactionId") Integer transactionId) {
		System.out.println(transactionId);
		String fToken = "FLWSECK_TEST-148a0343827f5276c49b73fa2e9b8884-X";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + fToken);
		String uri = "https://api.flutterwave.com/v3/transfers/" + transactionId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> response = restTemplate.exchange(uri, HttpMethod.GET,
				new HttpEntity<>("parameters", headers), Object.class);

		return response.getBody().toString();
	}

	//@GetMapping(value = "/api/v1/core-banking/transaction/{transactionId}")
	public String verifyTransactionFromPayStack(@PathVariable("transactionId") String transactionId) {
		String pToken = "sk_test_a14bf34a2f73ce858166189496b164990c8f4e84";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + pToken);
		String uri = "https://api.paystack.co/transfer/verify/" + transactionId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> response = restTemplate.exchange(uri, HttpMethod.GET,
				new HttpEntity<>("parameters", headers), Object.class);

		return response.getBody().toString();
	}

}
