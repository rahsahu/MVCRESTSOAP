package org.externalservice.service.invoice;

import java.math.BigDecimal;
import java.util.Random;

import org.externalservice.bean.Invoice;
import org.springframework.stereotype.Component;

import io.spring.guides.gs_producing_web_service.Country;

/**
 * Utility class for generating invoices.
 */
@Component
public class DataGenerator {

	private Random rand = new Random();

	public Invoice nextInvoice() {
		return new Invoice(rand.nextBoolean() ? iban() : null, address(), account(), dollars());
	}

	public Country nextCountry() {
		Country c = new Country();
		c.setId(rand.nextInt());
		c.setName(name());
		c.setPopulation(rand.nextLong());
		return c;
	}

	private BigDecimal dollars() {
		return new BigDecimal(1 + rand.nextInt(20_000));
	}

	private String account() {
		return "test-account " + rand.nextInt(1000) + 1000;
	}	
	
	private String name() {
		return "test-name " + rand.nextInt(1000) + 1000;
	}

	private String address() {
		return "Test Street " + rand.nextInt(100) + 1;
	}

	private String iban() {
		return "test-iban-" + rand.nextInt(1000) + 1000;
	}

}
