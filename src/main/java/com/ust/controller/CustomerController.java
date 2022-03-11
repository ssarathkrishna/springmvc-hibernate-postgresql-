package com.ust.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ust.model.Customer;
import com.ust.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private Logger logger;

	@Autowired
	private CustomerService customerService;

	@GetMapping("/getAll")
	@ResponseBody
	public ResponseEntity<List<Customer>> listCustomer() {
		logger.info("inside getAll listCustomer");
		List<Customer> theCustomers = customerService.getCustomers();
		return new ResponseEntity<List<Customer>>(theCustomers, HttpStatus.OK);
	}

	@GetMapping("/get")
	@ResponseBody
	public ResponseEntity<Customer> getCustomer(@RequestParam("customerId") int theId) {
		logger.info("inside get getCustomer");
		Customer theCustomers = customerService.getCustomer(theId);
		return new ResponseEntity<Customer>(theCustomers, HttpStatus.OK);
	}

	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> saveCustomer(@Validated @RequestBody Customer theCustomer) {
		logger.info("inside save saveCustomer");
		customerService.saveCustomer(theCustomer);
		return new ResponseEntity<String>("Saved Suscessfully", HttpStatus.CREATED);
	}

	@PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> updateCustomer(@Validated @RequestBody Customer theCustomer) {
		logger.info("inside update updateCustomer");
		customerService.saveCustomer(theCustomer);
		return new ResponseEntity<String>("Updated Suscessfully", HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	@ResponseBody
	public ResponseEntity<String> deleteCustomer(@RequestParam("customerId") int theId) {
		logger.info("inside delete deleteCustomer");
		customerService.deleteCustomer(theId);
		return new ResponseEntity<String>("Deleted Suscessfully", HttpStatus.OK);
	}

	@GetMapping(value = "/find")
	public String findCustomer() {
		logger.info("inside find findCustomer");
		return "index";
	}

	@GetMapping(value = "/show")
	public String showCustomer(@Validated Customer customer, Model model) {
		logger.info("inside show showCustomer");
		Customer theCustomers = customerService.getCustomer(customer.getId());
		model.addAttribute("customers", theCustomers);
		return "show";
	}

}
