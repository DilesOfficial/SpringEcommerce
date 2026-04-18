package com.dilusha.springecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String greeting(){
        return "Welcome to Spring E-Commerce!";
    }
}
