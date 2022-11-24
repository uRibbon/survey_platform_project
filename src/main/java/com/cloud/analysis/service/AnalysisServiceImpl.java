package com.cloud.analysis.service;

import com.cloud.analysis.dto.User.UserDTO;
import com.cloud.analysis.entity.Platform_analysis_option;
import com.cloud.analysis.entity.Survey_analysis;
import com.cloud.analysis.entity.Survey_analysis_option;
import com.cloud.analysis.repository.PlatformAnalysisOptionRepository;
import com.cloud.analysis.repository.PlatformAnalysisRepository;
import com.cloud.analysis.repository.SurveyAnalysisOptionRepository;
import com.cloud.analysis.repository.SurveyAnalysisRepository;
import com.cloud.analysis.service.kafka.consumer.KafkaConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AnalysisServiceImpl implements AnalysisService {
    @Autowired
    private final SurveyAnalysisRepository surveyAnalysisRepository;
    @Autowired
    private final SurveyAnalysisOptionRepository surveyAnalysisOptionRepository;
    @Autowired
    private final PlatformAnalysisRepository platformAnalysisRepository;
    @Autowired
    private final PlatformAnalysisOptionRepository platformAnalysisOptionRepository;

//    @Autowired
//    private final KafkaConsumer kafkaConsumer;

    @Override
    public List<Survey_analysis_option> getSurveyAnalysisList(Integer analysisId,Integer surveyId) {
        List<Survey_analysis_option> surveyAnalysisList = surveyAnalysisRepository.findSurveyAnalysisByColumn(analysisId,surveyId);
        return surveyAnalysisList;
    }

    @Override
    public List<Platform_analysis_option> getPlatformAnalysisList(Integer analysisId) {
        List<Platform_analysis_option> platformAnalysisList = surveyAnalysisRepository.findPlatformAnalysisByColumn(analysisId);
        return platformAnalysisList;
    }

    @Override
    public List<Object> getTypeSubjectList(Integer surveyId) {
        List<Object> Large = new ArrayList<>();
        List<Survey_analysis> TypeSubjectList = surveyAnalysisRepository.findSurveyAnalysisById(surveyId);
        TypeSubjectList.forEach(surveyAnalysis->{
            Map<String, Object> Middle = new HashMap<>();
            Middle.put("type", surveyAnalysis.getType());
            Middle.put("subject", surveyAnalysis.getSubject());

            Integer analysisId = surveyAnalysis.getAnalysisId();
            List<Map<String, Integer>> small = new ArrayList<>();
            List<Survey_analysis_option> OptionList = surveyAnalysisRepository.findSurveyAnalysisOptionById(analysisId);
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
    @Transactional
    public void AgeUpdate(List<UserDTO> answerUserList) {
        System.out.println("answerUserList = " + answerUserList);
        answerUserList.forEach((answerUser)->{
            int age = answerUser.getAge();
            int optionId=0;
            if(age<=10){
                optionId = 1;
            } else if (10<age & age<=20) {
                optionId = 2;
            } else if (20<age & age<=30){
                optionId = 3;
            }else if (30<age & age<=40){
                optionId = 4;
            }
            surveyAnalysisOptionRepository.updateValue(optionId);
        });
    }

    @Override
    @Transactional
    public void GenderUpdate(List<UserDTO> answerUserList) {
        answerUserList.forEach((answerUser)->{
            String gender = answerUser.getGender();
            int optionId=0;
            if(gender.equals("M")){
                optionId = 9;
            } else {
                optionId = 10;
            }
            surveyAnalysisOptionRepository.updateValue(optionId);
        });
    }

    @Override
    @Transactional
    public void JobUpdate(List<UserDTO> answerUserList){
        answerUserList.forEach((answerUser)->{
            String job = answerUser.getJob();
            int optionId=0;
            if(job.equals("FE개발자")){
                optionId = 5;
            } else if(job.equals("BE개발자")) {
                optionId = 6;
            } else if(job.equals("Infra개발자")) {
                optionId = 7;
            } else{
                optionId = 8;
            }
            surveyAnalysisOptionRepository.updateValue(optionId);
        });
    }

    @Override
    @Transient
    public void TimeUpdate(List<Map<String,Object>> answerDataList) {
        System.out.println("answerDataList = " + answerDataList);
        answerDataList.forEach((answerData)->{
            long systemTimeMills = (long)answerData.get("reg_dt");
            LocalDateTime systemLocalDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(systemTimeMills), TimeZone.getDefault().toZoneId());
            System.out.println("hour = " + systemLocalDateTime.getHour());

            int time = systemLocalDateTime.getHour();
            int optionId=0;
            if(6<time & time<=10){
                optionId = 11;
            } else if(10<time & time<=14) {
                optionId = 12;
            } else if(14<time & time<=18) {
                optionId = 13;
            } else if(18<time & time<=24){
                optionId = 14;
            }
            surveyAnalysisOptionRepository.updateValue(optionId);
        });
    }



}
