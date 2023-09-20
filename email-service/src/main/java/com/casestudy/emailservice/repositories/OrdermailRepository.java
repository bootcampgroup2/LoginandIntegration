package com.casestudy.emailservice.repositories;

import com.casestudy.emailservice.models.Ordermail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdermailRepository extends MongoRepository<Ordermail, String> {
    List<Ordermail> findByEmailAndRead(String email, boolean read);
}
