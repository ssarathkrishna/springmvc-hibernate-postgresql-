package com.ust.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ust.dao.CustomerDAO;
import com.ust.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private Logger logger;

	@Autowired
	private CustomerDAO customerDAO;

	@Transactional
	public List<Customer> getCustomers() {
		logger.info("inside getCustomers");
		return customerDAO.getCustomers();
	}

	@Transactional
	public void saveCustomer(Customer theCustomer) {
		logger.info("inside saveCustomer");
		customerDAO.saveCustomer(theCustomer);
	}

	@Transactional
	public Customer getCustomer(int theId) {
		logger.info("inside getCustomer");
		return customerDAO.getCustomer(theId);
	}

	@Transactional
	public void deleteCustomer(int theId) {
		logger.info("inside deleteCustomer");
		customerDAO.deleteCustomer(theId);
	}
}
