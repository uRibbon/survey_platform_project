package com.cloud.auth.service.kafka.producer;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer{

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String message) {
        System.out.println(String.format("Produce message : %s", message));
        this.kafkaTemplate.send(topic, message);
    }
}
