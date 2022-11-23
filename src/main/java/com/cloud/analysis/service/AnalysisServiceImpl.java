package com.cloud.analysis.service;

import com.cloud.analysis.entity.Platform_analysis_option;
import com.cloud.analysis.entity.Survey_analysis;
import com.cloud.analysis.entity.Survey_analysis_option;
import com.cloud.analysis.repository.AnalysisRepository;
import com.cloud.analysis.service.kafka.consumer.KafkaConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AnalysisServiceImpl implements AnalysisService {
    @Autowired
    private final AnalysisRepository analysisRepository;

    @Autowired
    private final KafkaConsumer kafkaConsumer;

    @Override
    public List<Survey_analysis_option> getSurveyAnalysisList(Integer analysisId,Integer surveyId) {
        List<Survey_analysis_option> surveyAnalysisList = analysisRepository.findSurveyAnalysisByColumn(analysisId,surveyId);
        return surveyAnalysisList;
    }

    @Override
    public List<Platform_analysis_option> getPlatformAnalysisList(Integer analysisId) {
        List<Platform_analysis_option> platformAnalysisList = analysisRepository.findPlatformAnalysisByColumn(analysisId);
        return platformAnalysisList;
    }

    @Override
    public List<Object> getTypeSubjectList(Integer surveyId) {
        List<Object> Large = new ArrayList<>();
        List<Survey_analysis> TypeSubjectList = analysisRepository.findSurveyAnalysisById(surveyId);
        TypeSubjectList.forEach(surveyAnalysis->{
            Map<String, Object> Middle = new HashMap<>();
            Middle.put("type", surveyAnalysis.getType());
            Middle.put("subject", surveyAnalysis.getSubject());

            Integer analysisId = surveyAnalysis.getAnalysisId();
            List<Map<String, Integer>> small = new ArrayList<>();
            List<Survey_analysis_option> OptionList = analysisRepository.findSurveyAnalysisOptionById(analysisId);
            OptionList.forEach(surveyAnalysisOption->{
                Map<String, Integer> optionInfo = new HashMap<>();
                optionInfo.put("option_id", surveyAnalysisOption.getOptionId());
                optionInfo.put("value", surveyAnalysisOption.getValue());
                small.add(optionInfo);
            });
            Middle.put("option", small);
            Large.add(Middle);
        });
        return Large;
    }

    @Override
    public Map<String, Object> Test(){
        Map<String, Object> message = kafkaConsumer.getMessage();
        return message;
    }




}
