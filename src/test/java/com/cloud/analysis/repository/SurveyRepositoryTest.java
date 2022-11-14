package com.cloud.analysis.repository;

import com.cloud.analysis.entity.*;
import com.cloud.analysis.entity.enums.Status;
import com.cloud.analysis.entity.enums.TableType;
import com.cloud.analysis.entity.enums.YesOrNo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SurveyRepositoryTest {

    @Autowired
    AnalysisRepository analysisRepository;

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
        Survey survey = Survey.builder()
                .surId(5)
                .title("등산 선호도 설문조사")
                .details("등산 선호도 설문조사 입니다")
                .surveyCategory(surveyCategoryRepository.findById(4).orElse(null))
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

    //// 카테고리별 설문 개수
    @Test
    void readSurveyCnt() {
        List<Object[]> surveyCntByCategoryList = surveyRepository.findSurveyCntByCategory();
        surveyCntByCategoryList.forEach(surveyCntByCategory -> {
            System.out.println(Arrays.toString(surveyCntByCategory));
        });


    }

    @Test
    void insert_to_survey() {
        Analysis analysis = Analysis.builder()
                .analysisId(2)
                .tableType(TableType.BAR)
                .build();
        analysisRepository.save(analysis);
    }
}
