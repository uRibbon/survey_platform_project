package com.cloud.survey.service.kafka.producer;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class KafkaProducer{

    private final KafkaTemplate<String, Map<String,Object>> kafkaTemplate;

    public void sendObject(String topic, Map<String,Object> map) {
        this.kafkaTemplate.send(topic, map);
    }


}
