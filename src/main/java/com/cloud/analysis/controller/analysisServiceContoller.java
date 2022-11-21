package com.cloud.analysis.controller;

import com.cloud.analysis.entity.Platform_analysis_option;
import com.cloud.analysis.entity.Survey_analysis;
import com.cloud.analysis.entity.Survey_analysis_option;
import com.cloud.analysis.service.AnalysisService;
import com.cloud.analysis.service.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="v1/survey")
@RequiredArgsConstructor
public class analysisServiceContoller {
    @Autowired
    private AnalysisService analysisService;

    private final KafkaProducer producer;

    @RequestMapping(value = "/survey_analysis", method = RequestMethod.POST)
    public List<Survey_analysis_option> getSurveyAnalysisList(@RequestParam (value = "analysis_Id") int analysisId) {
        List<Survey_analysis_option> allSurveyAnalysisList = analysisService.getSurveyAnalysisList(analysisId);
        return allSurveyAnalysisList;
    }

    @RequestMapping(value = "/platform_analysis", method = RequestMethod.POST)
    public List<Platform_analysis_option> getPlatformAnalysisList(@RequestParam (value = "platform_analysis_Id") int platformAnalysisId) {
        List<Platform_analysis_option> allPlatformAnalysisList = analysisService.getPlatformAnalysisList(platformAnalysisId);
        return allPlatformAnalysisList;
    }

    @PostMapping("/kafkaConnTest")
    public String sendMessage(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
        return "success";
    }

    @RequestMapping(value = "/survey_analysis_info", method = RequestMethod.POST)
    public List<Object> getTypeSubjectList(@RequestParam (value = "analysis_Id") int analysis_Id) {
        List<Object> allTypeSubjectList = analysisService.getTypeSubjectList(analysis_Id);
        return allTypeSubjectList;
    }



}
