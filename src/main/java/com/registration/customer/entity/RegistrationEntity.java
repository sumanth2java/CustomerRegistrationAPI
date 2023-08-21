package com.registration.customer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;

@ToString
@Getter
@Setter
@Document(collection = "customer")
public class RegistrationEntity {
    @Id
    private ObjectId _id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String streetAddress;
    private String city;
    private String state;
    private Long zipcode;
    private String userName;
    private String password;


}
