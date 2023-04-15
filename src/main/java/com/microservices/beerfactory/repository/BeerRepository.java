package com.microservices.beerfactory.repository;

import com.microservices.beerfactory.domain.Beer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends MongoRepository<Beer, String> {
    Beer findBeerByBeerName(String beerName);
}
