package com.registration.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
public class LoginEntity {
    private String userName;
    private String password;

}