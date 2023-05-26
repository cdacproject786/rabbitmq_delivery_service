package com.delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rest_id")
    private Long restaurantsId;

    @Column(name = "restName")
    private String restaurantsName;

    @Column(name = "rest_email")
    private String restaurantEmail;

    @Column(name = "rest_phone")
    private String restaurantPhone;

    public Restaurant(String restaurantsName, String restaurantEmail, String restaurantPhone) {
        this.restaurantsName = restaurantsName;
        this.restaurantEmail = restaurantEmail;
        this.restaurantPhone = restaurantPhone;
    }
}
