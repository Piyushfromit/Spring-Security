package com.springsecuritybyeazybytes.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {


    @GetMapping("/myCards")
    public String myCards(){

        return "My Card Details From database";
    }


}
