package web.controller;

import com.microservices.beerfactory.domain.Beer;
import com.microservices.beerfactory.services.BeerFactoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class BeerFactoryController {

    private final BeerFactoryService beerFactoryService;

    public BeerFactoryController(BeerFactoryService beerFactoryService) {
        this.beerFactoryService = beerFactoryService;
    }

    @PostMapping("/beer-factory/create")
    public void saveNewBeer(@RequestBody Beer beer){
        beerFactoryService.saveNewBeer(beer);
    }
    @GetMapping("/any")
    public ResponseEntity<String> check(){
        return new ResponseEntity<>("k", HttpStatus.OK);
    }

    @GetMapping("/produce/{beerId}")
    public void ProduceBeer(@PathVariable("beerId") String beerId, @RequestParam("quantity") Integer quantity){
        beerFactoryService.produceBeer(beerId, quantity);
    }
}
