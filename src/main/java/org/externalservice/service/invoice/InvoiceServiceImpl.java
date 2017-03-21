package org.externalservice.service.invoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.externalservice.bean.Invoice;
import org.springframework.stereotype.Service;

@Service("InvoiceService")
public class InvoiceServiceImpl implements InvoiceService {

	public static HashMap<String, Invoice> invoiceIdMap = null;
	static {
		DataGenerator g = new DataGenerator();

		invoiceIdMap = new HashMap<String, Invoice>();
		for (int i = 0; i <= 50; i++) {
			Invoice inv = g.nextInvoice();
			invoiceIdMap.put(inv.getIban(), inv);
		}
	}

	public List<Invoice> getAllInvoices() {

		List<Invoice> invoice = new ArrayList<Invoice>(invoiceIdMap.values());

		return invoice;

	}

	public Invoice getInvoice(String id) {
		Invoice Invoice = invoiceIdMap.get(id);
		return Invoice;
	}

	public Invoice addInvoice(Invoice Invoice) {
		// if invoice already exists then not adding duplicate
		if (invoiceIdMap.containsKey(Invoice.getIban()) == true)
			return null;
		invoiceIdMap.put(Invoice.getIban(), Invoice);
		return Invoice;
	}

	public Invoice updateInvoice(Invoice Invoice) {
		// if invoice not present then null
		if (invoiceIdMap.containsKey(Invoice.getIban()) == false)
			return null;
		invoiceIdMap.put(Invoice.getIban(), Invoice);
		return Invoice;

	}

	public boolean deleteInvoice(String id) {
		if (invoiceIdMap.containsKey(id) == false)
			return false;
		invoiceIdMap.remove(id);
		return true;
	}

	public HashMap<String, Invoice> getinvoiceIdMap() {
		return invoiceIdMap;
	}

}
