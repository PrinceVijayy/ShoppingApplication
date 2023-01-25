package com.ojas.Shopping.service.impl;

import com.ojas.Shopping.dto.CustomerDTO;
import com.ojas.Shopping.entity.CustomerEntity;
import com.ojas.Shopping.repository.CustomerRepository;
import com.ojas.Shopping.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String registerCustomer(CustomerDTO customerDTO) {
        CustomerEntity customer=new CustomerEntity();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setDateOfBirth(customerDTO.getDateOfBirth());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(customerDTO.getPassword());
        try {
            customerRepository.save(customer);
            return "Successfully Created";
        } catch (Exception e) {
            return "Failed To Create";
        }

    }
}


























