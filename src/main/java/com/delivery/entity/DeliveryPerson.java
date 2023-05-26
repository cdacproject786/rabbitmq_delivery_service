package com.delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "delivery_person")
public class DeliveryPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private long personId;
    @Column(name = "fname",nullable = false)
    private String firstName;
    @Column(name = "lname",nullable = false)
    private String lastName;
    @Column(name = "email")
    private String personEmail;
    @Column(name = "phone")
    private String personPhone;

    public DeliveryPerson(String firstName, String lastName, String personEmail, String personPhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personEmail = personEmail;
        this.personPhone = personPhone;
    }
}
