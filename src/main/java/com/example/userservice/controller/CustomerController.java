package com.example.userservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @GetMapping
    public String post(){
        return "This Is Customer Page";
    }

    @PutMapping
    public String put(){
        return"This Is Customer Page"; }

    @DeleteMapping
    public String delete(){
        return "This Is Customer Page";
    }

}
