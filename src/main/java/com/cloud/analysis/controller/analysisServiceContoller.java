package com.cloud.analysis.controller;

import com.cloud.analysis.entity.Survey_analysis_option;
import com.cloud.analysis.service.AnalysisService;
import com.cloud.analysis.service.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Survey_analysis_option> getAnalysisList(@RequestParam (value = "analysis_Id") int analysisId) {
        List<Survey_analysis_option> allAnalysisList = analysisService.getAnalysisList(analysisId);
        return allAnalysisList;
    }

    @PostMapping("/kafkaConnTest")
    public String sendMessage(@RequestParam("message") String message) {
        this.producer.sendMessage(message);

        return "success";
    }
}
