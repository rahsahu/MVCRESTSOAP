package org.externalservice.service.bank;

import org.externalservice.bean.Payment;

/**
 * Contract for communication with bank.
 */
public interface BankingService {

	String pay(Payment payment) throws PaymentException;

}
