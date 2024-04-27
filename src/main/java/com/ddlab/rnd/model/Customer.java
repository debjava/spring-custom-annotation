package com.ddlab.rnd.model;

import com.ddlab.rnd.annotation.CashValidation;

import lombok.Data;

@Data
public class Customer {
	
	private String actNo;
	private String name;
	@CashValidation(value = 50000)
	private int amount;

}
