package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Menu;
import com.cloud.analysis.entity.Survey;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SurveyRepositoryTest {
    @Autowired
    SurveyRepository surveyRepository;

    @Test
    void read(){
        List<Survey> surveyList = surveyRepository.findAll();
        surveyList.forEach(survey -> {
            System.out.println("survey = " + survey);
        });
    }
}