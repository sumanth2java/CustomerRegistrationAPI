package com.registration.customer.repository;

import com.registration.customer.entity.RegistrationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends MongoRepository<RegistrationEntity, Long> {

}
