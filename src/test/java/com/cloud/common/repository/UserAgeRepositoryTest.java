//package com.cloud.common.repository;
//
//import com.cloud.common.entity.SurveyState;
//import com.cloud.common.entity.UserAge;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class UserAgeRepositoryTest {
//    @Autowired
//    UserAgeRepository userAgeRepository;
//
//    @Test
//    void insert() {
//        userAgeRepository.save(UserAge.builder()
//                .code(10)
//                .content("10대")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        userAgeRepository.save(UserAge.builder()
//                .code(20)
//                .content("20대")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        userAgeRepository.save(UserAge.builder()
//                .code(30)
//                .content("30대")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        userAgeRepository.save(UserAge.builder()
//                .code(40)
//                .content("40대")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        userAgeRepository.save(UserAge.builder()
//                .code(50)
//                .content("50대")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        userAgeRepository.save(UserAge.builder()
//                .code(60)
//                .content("60대 이상")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//    }
//
//}
