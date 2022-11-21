package com.cloud.survey.service.kafka.producer;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class KafkaProducer{

    private final KafkaTemplate<String, String> kafkaTemplateStr;
    private final KafkaTemplate<String, Map<String,String>> kafkaTemplateStrMap;
    private final KafkaTemplate<String, Map<String,Object>> kafkaTemplateObjectMap;

    public void sendString(String topic, String str) {
        this.kafkaTemplateStr.send(topic, str);
    }
    public void sendStrMap(String topic, Map<String,String> map) {
        this.kafkaTemplateStrMap.send(topic, map);
    }
    public void sendObjetMap(String topic, Map<String,Object> map) {
        this.kafkaTemplateObjectMap.send(topic, map);
    }
}
