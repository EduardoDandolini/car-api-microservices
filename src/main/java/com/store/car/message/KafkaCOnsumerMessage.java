package com.store.car.message;

import com.store.car.dto.CarPostDTO;
import com.store.car.service.CarPostServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaCOnsumerMessage {

    private final Logger log = LoggerFactory.getLogger(KafkaCOnsumerMessage.class);
    @Autowired
    private CarPostServiceImpl carPostService;
    @KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
    public void listening(CarPostDTO carPostDTO){

        log.info("Received Message: {}", carPostDTO);
        carPostService.newPostDetails(carPostDTO);
    }
}
