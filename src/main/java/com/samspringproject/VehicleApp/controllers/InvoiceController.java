package com.samspringproject.VehicleApp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samspringproject.VehicleApp.models.Invoice;
import com.samspringproject.VehicleApp.services.ClientsService;
import com.samspringproject.VehicleApp.services.InvoiceService;
import com.samspringproject.VehicleApp.services.InvoiceStatusService;

@Controller
public class InvoiceController {
	
	@Autowired private InvoiceService invoiceService;
	@Autowired private ClientsService clientsService;
	@Autowired private InvoiceStatusService invoiceStatusService;
	
	//Get All Invoice
	@GetMapping("invoice")
	public String findAll(Model model){		
		model.addAttribute("invoices", invoiceService.getInvoices());
		model.addAttribute("clients", clientsService.getClients());
		model.addAttribute("invoiceStatuses", invoiceStatusService.getInvoiceStatuss());
		return "invoice";
	}	
	
	@RequestMapping("invoices/findById") 
	@ResponseBody
	public Optional<Invoice> findById(Integer id)
	{
		return invoiceService.findById(id);
	}
	
	//Add State
	@PostMapping(value="invoices/addNew")
	public String addNew(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoice";
	}	
	
	@RequestMapping(value="invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoice";
	}
	
	@RequestMapping(value="invoices/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		invoiceService.delete(id);
		return "redirect:/invoice";
	}
}
