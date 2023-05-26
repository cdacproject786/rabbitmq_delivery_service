package com.delivery.controller;

import com.delivery.service.RestaurantService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/rest/{custemail}")
    public ResponseEntity<?> dispatchOrder(@PathVariable("custemail") String customerEmail) throws MessagingException {
        this.restaurantService.sendOrderdespatchmail(customerEmail);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
