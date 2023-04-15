package com.microservices.beerfactory;

import com.microservices.beerfactory.domain.Beer;
import com.microservices.beerfactory.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class BeerFactoryApplication {

    private final BeerRepository beerRepository;

    public BeerFactoryApplication(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BeerFactoryApplication.class, args);
    }


    @Bean
    CommandLineRunner run(){
        if (beerRepository.count() == 0) {
            return args -> {
                beerRepository.save(Beer.builder()
                        .beerName("Mango Bobs")
                        .beerStyle("IPA")
                        .upc(3701000001L)
                        .producedQuantity(1)
                        .build());

                beerRepository.save(Beer.builder()
                        .beerName("Retro Boomer")
                        .beerStyle("IPA")
                        .upc(3701000002L)
                        .producedQuantity(1)
                        .build());

                beerRepository.save(Beer.builder()
                        .beerName("Galaxy Pink")
                        .beerStyle("PALE_ALE")
                        .upc(3701000003L)
                        .producedQuantity(1)
                        .build());

                beerRepository.save(Beer.builder()
                        .beerName("Miller Lite")
                        .beerStyle("PALE_ALE")
                        .upc(3701000004L)
                        .producedQuantity(1)
                        .build());
            };
        }
        return null;
    }
}
