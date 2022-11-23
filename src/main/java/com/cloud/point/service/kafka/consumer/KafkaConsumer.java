package com.cloud.point.service.kafka.consumer;

import com.cloud.point.service.UserPointService;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@Log4j2
@Service
public class KafkaConsumer {

    // private final UserPointService userPointService;

    @KafkaListener(topics = "ANSWER_POINT", groupId = "survey_platform")
    public void consume(Map<String,Object> accruePointMap) {
        Object user_id = accruePointMap.get("user_id");
        Object surId = accruePointMap.get("sur_id");
        Object type = accruePointMap.get("type");

        System.out.println("user_id " + user_id);
        System.out.println("sur_id " + surId);
        System.out.println("type " + type);
    }
}