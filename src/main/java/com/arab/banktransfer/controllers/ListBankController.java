package com.arab.banktransfer.controllers;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ListBankController {

	@GetMapping(value = "/api/v1/core-banking/banks/", produces = "application/json")
	public String getBankList() {
		return callFlutterwave();
	}

	@GetMapping(value = "/api/v1/core-banking/banks/{provider}", produces = "application/json")
	public String getBankList(@PathVariable(name = "provider", required = false) String provider) {	
		switch (provider) {
		case "paystack":
			return callPayStack();
		case "flutter":
			return callFlutterwave();			
		default:
			return callFlutterwave();
		}
	}

	private String callPayStack() {
		String pToken = "sk_test_a14bf34a2f73ce858166189496b164990c8f4e84";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + pToken);
		String uri = "https://api.paystack.co/bank/";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET,
				new HttpEntity<>("parameters", headers), String.class);

		return response.getBody().toString();
	}

	private String callFlutterwave() {
		String fToken = "FLWSECK_TEST-148a0343827f5276c49b73fa2e9b8884-X";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + fToken);
		String uri = "https://api.flutterwave.com/v3/banks/NG";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET,
				new HttpEntity<>("parameters", headers), String.class);

		return response.getBody().toString();
	}

}
