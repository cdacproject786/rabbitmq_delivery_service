package com.delivery.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPersonRequest {

    private long personId;

    private String firstName;

    private String lastName;

    private String personEmail;

    private String personPhone;
}