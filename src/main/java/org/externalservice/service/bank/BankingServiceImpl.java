package org.externalservice.service.bank;

import java.util.Random;

import org.externalservice.bean.Payment;
import org.springframework.stereotype.Service;

/**
 * Mock service that simulates some banking behavior. In real world, we might
 * use some web service or a proxy of real service.
 */
@Service("bankingService")
public class BankingServiceImpl implements BankingService {

	private final Random rand = new Random();

	public String pay(Payment payment) throws PaymentException {

		if (rand.nextDouble() > 0.9) {

			throw new PaymentException("Banking services are offline, try again later!");
		}

		System.out.println("Processing payment " + payment);
		return "Completed";
	}

}
