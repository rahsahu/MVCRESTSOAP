package org.externalservice.controller;

import org.externalservice.bean.Payment;
import org.externalservice.service.bank.BankingServiceImpl;
import org.externalservice.service.bank.PaymentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

	@Autowired
	BankingServiceImpl bankingService = new BankingServiceImpl();

	@RequestMapping(value = "/test", method = RequestMethod.GET, headers = "Accept=application/json")
	public String test() {
		return "test";
	}

	@RequestMapping(value = "/pay", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addBank(@RequestBody Payment payment) {
		try {
			return bankingService.pay(payment);
		} catch (PaymentException e) {
			e.printStackTrace();
			return "Failed";
		}
	}
}