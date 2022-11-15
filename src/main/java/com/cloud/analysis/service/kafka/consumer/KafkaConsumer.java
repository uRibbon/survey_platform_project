package com.cloud.analysis.service.kafka.consumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumer {

    //현재 kafkaTest를 위한 test topic 설정 -> 추후 auth-topic 변동 예정
    @KafkaListener(topics = "test", groupId = "survey_platform")
    public void consume(String message) throws IOException {
        System.out.println(String.format("Consumed message : %s", message));
    }
}