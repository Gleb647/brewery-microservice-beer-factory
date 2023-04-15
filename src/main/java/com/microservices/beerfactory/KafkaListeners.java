package com.microservices.beerfactory;

import com.jayway.jsonpath.JsonPath;
import com.microservices.beerfactory.services.BeerFactoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaListeners {

    private final BeerFactoryService beerFactoryService;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaListeners(BeerFactoryService beerFactoryService, KafkaTemplate<String, String> kafkaTemplate) {
        this.beerFactoryService = beerFactoryService;
        this.kafkaTemplate = kafkaTemplate;
    }


    @KafkaListener(topics="Produce", groupId="groupId")
    void listen(String data){
        String beerName = JsonPath.read(data, "$.beerName");
        Integer quantityToProduce = JsonPath.read(data, "$.quantity");

        beerFactoryService.produceBeer(beerName, quantityToProduce);
        kafkaTemplate.send("BeerProduce", data);
    }
}
