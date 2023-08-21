package com.registration.customer.repository;

import com.registration.customer.entity.LoginEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginRepository extends MongoRepository<LoginEntity, Long> {
    LoginEntity findByUserName(String userName);
}