package com.springsecuritybyeazybytes.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {


    @GetMapping("/myBalance")
    public String accBalance(){

        return "My Account Balance From Database";
    }


}
