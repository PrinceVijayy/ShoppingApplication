package com.ojas.Shopping.service;

import com.ojas.Shopping.dto.CustomerDTO;
import com.ojas.Shopping.entity.Customer;
import org.springframework.stereotype.Service;


public interface CustomerService {

    public String registerCustomer(CustomerDTO customerDTO);

}
