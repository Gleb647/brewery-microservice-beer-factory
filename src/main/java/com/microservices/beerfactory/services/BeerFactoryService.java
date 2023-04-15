package com.microservices.beerfactory.services;

import com.microservices.beerfactory.domain.Beer;

public interface BeerFactoryService {
    void saveNewBeer(Beer beer);

    void produceBeer(String beerName, Integer quantity);
}
