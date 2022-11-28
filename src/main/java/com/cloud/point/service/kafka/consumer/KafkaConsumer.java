package com.cloud.point.service.kafka.consumer;

import com.cloud.point.service.UserPointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.Map;

@Log4j2
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final UserPointService userPointService;

    @KafkaListener(topics = "ANSWER_POINT", groupId = "survey_platform")
    public void consume(@NotNull Map<String,Object> map) {
        //System.out.println("map = " + map);
        Map<String, String> accurePointMap = (Map<String, String>) map.get("accure_point_map");
        String userId = accurePointMap.get("user_id");

        userPointService.updateUserPoint(userId);
    }



}