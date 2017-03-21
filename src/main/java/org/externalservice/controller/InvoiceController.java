package org.externalservice.controller;

import java.util.List;

import org.externalservice.bean.Invoice;
import org.externalservice.service.invoice.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {
	@Autowired
	InvoiceServiceImpl InvoiceServiceImpl;

	@RequestMapping(value = "/invoices", method = RequestMethod.GET, headers = "Accept=application/json" )
	public List<Invoice> getCountries() {
		List<Invoice> listOfCountries = InvoiceServiceImpl.getAllInvoices();
		return listOfCountries;
	}

	@RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Invoice getInvoiceById(@PathVariable String id) {
		System.out.println();
		return InvoiceServiceImpl.getInvoice(id);
	}

	@RequestMapping(value = "/invoice", method = RequestMethod.POST, headers = "Accept=application/json")
	public Invoice addInvoice(@RequestBody Invoice Invoice) {
		return InvoiceServiceImpl.addInvoice(Invoice);
	}

	@RequestMapping(value = "/invoice", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Invoice updateInvoice(@RequestBody Invoice Invoice) {
		return InvoiceServiceImpl.updateInvoice(Invoice);

	}

	@RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteInvoice(@PathVariable("id") String id) {
		InvoiceServiceImpl.deleteInvoice(id);

	}
}