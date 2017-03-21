package org.externalservice.service.invoice;

import java.util.HashMap;
import java.util.List;

import org.externalservice.bean.Invoice;

public interface InvoiceService {

	public List<Invoice> getAllInvoices();

	public Invoice getInvoice(String id);

	public Invoice addInvoice(Invoice Invoice);

	public Invoice updateInvoice(Invoice Invoice);

	public boolean deleteInvoice(String id);

	public HashMap<String, Invoice> getinvoiceIdMap();

}
