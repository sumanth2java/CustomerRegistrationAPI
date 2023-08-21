package com.registration.customer.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class LoginEntity {
        private String username;
        private String password;

}
