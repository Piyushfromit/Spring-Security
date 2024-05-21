package com.springsecuritybyeazybytes.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LonsController {


    @GetMapping("/myLone")
    public String myLone(){
        return "My Lone Details From Database ";
    }


}
