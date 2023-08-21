package com.registration.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginEntity {
    private String userName;
    private String password;

}