package com.code.sample.event.service.impl.repository;

import com.code.sample.event.service.dto.Speaker;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface SpeakerMongoRepository extends MongoRepository<Speaker, BigInteger> {

}
