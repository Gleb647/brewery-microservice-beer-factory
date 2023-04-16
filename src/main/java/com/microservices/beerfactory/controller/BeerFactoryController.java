package com.microservices.beerfactory.controller;

import com.microservices.beerfactory.domain.Beer;
import com.microservices.beerfactory.services.BeerFactoryService;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


@RequestMapping("/factory")
@RestController
public class BeerFactoryController {

    private final BeerFactoryService beerFactoryService;

    public BeerFactoryController(BeerFactoryService beerFactoryService) {
        this.beerFactoryService = beerFactoryService;
    }

    @PostMapping("/create")
    public void saveNewBeer(@RequestBody Beer beer){
        LocalDateTime time = LocalDateTime.now();
        beer.setCreateDate(time);
        beer.setLastModifiedDate(time);
        beerFactoryService.saveNewBeer(beer);
    }

    @GetMapping("/produce/{beerId}")
    public void ProduceBeer(@PathVariable("beerId") String beerId, @RequestParam("quantity") Integer quantity){
        beerFactoryService.produceBeer(beerId, quantity);
    }

    @GetMapping("/beer")
    public ResponseEntity<List<Beer>> getBeer(){
        return new ResponseEntity<>(beerFactoryService.getBeer(), HttpStatus.OK);
    }
}
