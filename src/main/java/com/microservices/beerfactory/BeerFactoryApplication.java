package com.microservices.beerfactory;

import com.microservices.beerfactory.domain.Beer;
import com.microservices.beerfactory.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

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
            LocalDateTime time = LocalDateTime.now();
            return args -> {
                beerRepository.save(Beer.builder()
                        .beerName("Mango Bobs")
                        .beerStyle("IPA")
                        .upc(3701000001L)
                        .createDate(time)
                        .lastModifiedDate(time)
                        .producedQuantity(1)
                        .build());

                beerRepository.save(Beer.builder()
                        .beerName("Retro Boomer")
                        .beerStyle("IPA")
                        .upc(3701000002L)
                        .createDate(time)
                        .lastModifiedDate(time)
                        .producedQuantity(1)
                        .build());

                beerRepository.save(Beer.builder()
                        .beerName("Galaxy Pink")
                        .beerStyle("PALE_ALE")
                        .upc(3701000003L)
                        .createDate(time)
                        .lastModifiedDate(time)
                        .producedQuantity(1)
                        .build());

                beerRepository.save(Beer.builder()
                        .beerName("Miller Lite")
                        .beerStyle("PALE_ALE")
                        .upc(3701000004L)
                        .createDate(time)
                        .lastModifiedDate(time)
                        .producedQuantity(1)
                        .build());
            };
        }
        return null;
    }
}
