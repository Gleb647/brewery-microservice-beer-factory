package com.microservices.beerfactory.services;

import com.microservices.beerfactory.domain.Beer;
import com.microservices.beerfactory.repository.BeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerFactoryServiceImpl implements BeerFactoryService{

    private final BeerRepository beerRepository;

    public BeerFactoryServiceImpl(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void saveNewBeer(Beer beer) {
        beerRepository.save(beer);
    }

    @Override
    public void produceBeer(String beerName, Integer quantity) {
        System.out.println(beerRepository.findBeerByBeerName(beerName));
        Beer beer = beerRepository.findBeerByBeerName(beerName);
        beer.setProducedQuantity(quantity);
        beerRepository.save(beer);
    }

    @Override
    public List<Beer> getBeer(){
        return beerRepository.findAll();
    }
}
