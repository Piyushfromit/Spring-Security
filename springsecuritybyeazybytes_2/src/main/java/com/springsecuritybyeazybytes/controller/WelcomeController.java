package com.springsecuritybyeazybytes.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


    @GetMapping("/welcome")
    public String welcomeMessage(){

        System.out.println("Piyush ");
        System.out.println("Bittu  ");
        System.out.println("Bittu  ");

        return "Learning Spring Security By Easy Bytes On Udemy";
    }


}
