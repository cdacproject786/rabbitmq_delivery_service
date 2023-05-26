package com.delivery.controller;

import com.delivery.service.DeliveryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeliveryPersonController {

    @Autowired
    private DeliveryPersonService service;

    @PostMapping("/delivery/{email}")
    public ResponseEntity<?> orderdelivered(@PathVariable("email") String email)
    {
        this.service.orderDeliveredService(email);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
