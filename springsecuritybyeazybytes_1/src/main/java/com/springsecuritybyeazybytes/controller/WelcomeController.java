package com.springsecuritybyeazybytes.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


    @GetMapping("/welcome")
    public String WelcomeMessage(){
        return "Learning Spring Security By Eazy Bytes On Udemy";
    }


}
