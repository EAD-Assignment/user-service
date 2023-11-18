package com.example.userservice.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryController {

    @GetMapping
    public String post(){
        return "This Is Delivery Person page";
    }

    @PutMapping
    public String put(){
        return "This Is Delivery Person page";
    }

    @DeleteMapping
    public String delete(){
        return "This Is Delivery Person page";
    }

}
