package com.code.sample.event.service.impl.repository;

import com.code.sample.event.service.dto.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface EventMongoRepository extends MongoRepository<Event, BigInteger> {

    List<Event> findByTitle(String title);
}
