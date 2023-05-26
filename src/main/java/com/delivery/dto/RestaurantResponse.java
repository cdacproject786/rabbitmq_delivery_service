package com.delivery.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RestaurantResponse {

    private Long restaurantsId;
    private String restaurantsName;
    private String restaurantEmail;
    private String restaurantPhone;
}
