package com.cloud.point.service.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.Map;

@Log4j2
@Service
public class KafkaConsumer {

    // private final UserPointService userPointService;

    @KafkaListener(topics = "ANSWER_POINT", groupId = "survey_platform")
    public void consume(Map<String,Object> accruePointMap) {
        Object map2 = accruePointMap.get(("accrue_point_map"));
        ObjectMapper objectMapper = new ObjectMapper();

        Map result = objectMapper.convertValue(map2, Map.class);
        result.get("user_id");

//        String userId = accruePointMap.get()
//        String surId = accruePointMap.get("accrue_point_map").
//        String type = accruePointMap.get("accrue_point_map")
//
//        System.out.println("user_id: " + userId);
//        System.out.println("sur_id: " + surId);
//        System.out.println("type: " + type);
    }



}