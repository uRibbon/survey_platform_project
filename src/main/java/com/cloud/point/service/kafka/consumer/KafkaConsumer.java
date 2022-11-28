package com.cloud.point.service.kafka.consumer;

import com.cloud.point.entity.PointHistory;
import com.cloud.point.service.PointHistoryService;
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
    private final PointHistoryService pointHistoryService;

    @KafkaListener(topics = "ANSWER_POINT", groupId = "survey_platform")
    public void consume(Map<String,Object> map) {
        Map<String, String> accruePointMap = (Map<String, String>) map.get("accrue_point_map");
        String userId = accruePointMap.get("user_id");
        String pointType = accruePointMap.get("type");
        userPointService.updateUserPoint(userId, pointType);
        pointHistoryService.insertPointHistory(userId, pointType);
    }
}