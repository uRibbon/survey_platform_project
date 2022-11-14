package com.cloud.analysis.controller;

import com.cloud.analysis.entity.Analysis;
import com.cloud.analysis.entity.Analysis_option;
import com.cloud.analysis.service.AnalysisService;
import com.cloud.analysis.service.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="v1/survey")
@RequiredArgsConstructor
public class analysisServiceContoller {
    @Autowired
    private AnalysisService analysisService;

    private final KafkaProducer producer;
    @GetMapping("/test")
    public String test() {
        return "분석 서버로부터 응답";
    }

    @RequestMapping(value = "/analysis", method = RequestMethod.POST)
    public List<Analysis_option> getAnalysisList(@RequestParam (value = "analysis_Id") int analysisId) {
        List<Analysis_option> allAnalysisList = analysisService.getAnalysisList(analysisId);
        return allAnalysisList;
    }

    @PostMapping("/kafkaConnTest")
    public String sendMessage(@RequestParam("message") String message) {
        this.producer.sendMessage(message);

        return "success";
    }
}
