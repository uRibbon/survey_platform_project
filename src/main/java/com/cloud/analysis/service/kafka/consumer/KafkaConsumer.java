package com.cloud.analysis.service.kafka.consumer;
import com.cloud.analysis.dto.User.UserDTO;
import com.cloud.analysis.service.AnalysisService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class KafkaConsumer {

    @Autowired
    AnalysisService analysisService;

    Map<String,Object>  message;

    //현재 kafkaTest를 위한 test topic 설정 -> 추후 auth-topic 변동 예정
    @KafkaListener(topics = "ANSWER_ANALYSIS", groupId = "survey_platform")
    public void consume(Map<String,Object> message) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println(String.format("ANSWER_ANALYSIS: %s", message));
        this.message = message;
        List<Map<String,Object>> answerDataList = (List<Map<String,Object>>)message.get("answer_data_list");
        List<UserDTO> answerUserList = objectMapper.convertValue(message.get("answer_user_list"), new TypeReference<List<UserDTO>>() {});

        analysisService.AgeUpdate(answerUserList);
        analysisService.JobUpdate(answerUserList);
        analysisService.GenderUpdate(answerUserList);
        analysisService.TimeUpdate(answerDataList);
    }

    public Map<String,Object> getMessage(){
        return this.message;
    }
}

