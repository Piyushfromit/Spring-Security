package com.springsecuritybyeazybytes.controller;


import com.springsecuritybyeazybytes.model.Customer;
import com.springsecuritybyeazybytes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRegisterController {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity <String> registerUser(@RequestBody Customer customer){
        Customer savedCustomer = null ;
        ResponseEntity responseEntity = null ;
        try {
            String hashPwd = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPwd);
            savedCustomer = customerRepository.save(customer);
            if(savedCustomer.getId() > 0 ){
                responseEntity = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("User Registered Successfully");
            }
        }catch (Exception e){
            responseEntity = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to "+  e.getMessage());
        }
        return responseEntity;
    }


}
