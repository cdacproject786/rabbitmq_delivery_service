package com.delivery.dto;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    private long customerId;
    private String firstName;
    private String password;
    private String lastName;
    private String email;
    private String phoneNo;
    private long otp;

}
