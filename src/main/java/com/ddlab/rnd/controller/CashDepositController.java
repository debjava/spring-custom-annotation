package com.ddlab.rnd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ddlab.rnd.aop.AppLogger;
import com.ddlab.rnd.model.Customer;

import jakarta.validation.Valid;

@RestController
public class CashDepositController {
	
	@AppLogger
	@PutMapping(path="/cash")
	public ResponseEntity<String> depositCash(@Valid @RequestBody Customer customer) {
		System.out.println("Customer depositing ..."+customer.getAmount());
		return new ResponseEntity<String>("Cash Deposited successfully.", HttpStatus.OK);
	}

}
