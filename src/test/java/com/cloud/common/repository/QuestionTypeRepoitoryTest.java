//package com.cloud.common.repository;
//
//import com.cloud.common.entity.QuestionType;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class QuestionTypeRepoitoryTest {
//    @Autowired
//    QuestionTypeRepoitory questionTypeRepoitory;
//
//    @Test
//    void insert() {
//        questionTypeRepoitory.save(QuestionType.builder()
//                .code("Sub")
//                .content("주관식")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        questionTypeRepoitory.save(QuestionType.builder()
//                .code("NumMul")
//                .content("객관식(중복 허용)")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        questionTypeRepoitory.save(QuestionType.builder()
//                .code("NumOnly")
//                .content("객관식(중복 불가)")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        questionTypeRepoitory.save(QuestionType.builder()
//                .code("YN")
//                .content("찬부식")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        questionTypeRepoitory.save(QuestionType.builder()
//                .code("Grd")
//                .content("서열식")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//    }
//
//}
