package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Menu;
import com.cloud.analysis.entity.Survey;
import com.cloud.analysis.entity.SurveyCategory;
import com.cloud.analysis.entity.enums.Status;
import com.cloud.analysis.entity.enums.YesOrNo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SurveyRepositoryTest {
    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    SurveyCategoryRepository surveyCategoryRepository;

    @Test
    void read(){
        List<Survey> surveyList = surveyRepository.findAll();
        surveyList.forEach(survey -> {
            System.out.println("survey = " + survey);
        });
    }

    @Test
    void insert() {
        SurveyCategory surveyCategory = SurveyCategory
                .builder()
                .surCatId(1)
                .content("학교")
                .build();
        surveyCategoryRepository.save(surveyCategory);
        Survey survey = Survey.builder()
                .surId(1)
                .title("동아리 설문조사")
                .details("동아리 설문조사 입니다")
                .surveyCategory(surveyCategory)
                .version(1.2f)
                .status(Status.proc)
                .dueDt(LocalDateTime.now())
                .groupId(1)
                .regId("yena")
                .regDt(LocalDateTime.now())
                .modId("yena")
                .modDt(LocalDateTime.now())
                .isLogin(YesOrNo.Y)
                .isPrivate(YesOrNo.Y)
                .isModify(YesOrNo.Y)
                .isAnnoy(YesOrNo.Y)
                .build();
        surveyRepository.save(survey);
    }
}
