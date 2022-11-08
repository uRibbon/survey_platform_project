package com.cloud.analysis.repository;

import com.cloud.analysis.entity.SurveyCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SurveyCategoryRepositoryTest {
    @Autowired
    SurveyCategoryRepository surveyCategoryRepository;

    @Test
    void read(){
        List<SurveyCategory> surveyCategoryList = surveyCategoryRepository.findAll();
        surveyCategoryList.forEach(surveyCategory -> {
            System.out.println("surveyCategory = " + surveyCategory);
        });
    }
}