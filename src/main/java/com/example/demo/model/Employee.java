package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    Integer id;
    String firstName;
    String lastName;
    String email;
    Double salary;
}
