package com.cloud.analysis.service.kafka.consumer;
import org.apache.tomcat.util.json.ParseException;
import org.json.simple.parser.JSONParser;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

@Service
public class KafkaConsumer {
    //현재 kafkaTest를 위한 test topic 설정 -> 추후 auth-topic 변동 예정
    @KafkaListener(topics = "test", groupId = "survey_platform")
    public void consume(String message) throws IOException {
        System.out.println(String.format("Answer Registered: %s", message));
    }

//    @KafkaListener(topics = "test", groupId = "survey_platform")
//    public String consume(String message) throws IOException {
//        System.out.println(String.format("Incomming: %s", message));
//        try {
//            JSONParser parser = new JSONParser();
//            Object obj = parser.parse(message);
//            JSONObject jsonObj = (JSONObject) obj;
//
//            String msg = (String) jsonObj.get("msg");
//            System.out.printf("Consumed message : %s%n", msg);
//        } catch (org.json.simple.parser.ParseException ignored) {
//            System.out.println("변환에 실패");
//            ignored.printStackTrace();
//        }
//        return message;
//    }
}

