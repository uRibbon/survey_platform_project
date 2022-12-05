//package com.cloud.common.repository;
//
//import com.cloud.common.entity.QuestionType;
//import com.cloud.common.entity.SurveyState;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class SurveyStateRepositoryTest {
//    @Autowired
//    SurveyStateRepository surveyStateRepository;
//
//    @Test
//    void insert() {
//        surveyStateRepository.save(SurveyState.builder()
//                .code("P")
//                .content("제작")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        surveyStateRepository.save(SurveyState.builder()
//                .code("I")
//                .content("배포")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        surveyStateRepository.save(SurveyState.builder()
//                .code("D")
//                .content("삭제")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//    }
//}
