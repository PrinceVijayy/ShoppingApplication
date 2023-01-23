package com.ojas.Shopping.controller;

import com.ojas.Shopping.dto.CustomerDTO;
import com.ojas.Shopping.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("create")
    public Map<String,String> registerCustomer(@RequestBody CustomerDTO customerDTO){
        Map<String ,String> status=new HashMap<>();
        status.put("status",customerService.registerCustomer(customerDTO));
        return status;
    }
}
