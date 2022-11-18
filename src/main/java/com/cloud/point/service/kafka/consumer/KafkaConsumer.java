package com.cloud.point.service.kafka.consumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Log4j2
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "auth-topic", groupId = "survey_platform")
    public void consume(String message) throws IOException {
        System.out.println(String.format("Consumed message : %s", message));
    }
}