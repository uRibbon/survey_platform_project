//package com.cloud.common.repository;
//
//import com.cloud.common.entity.UserAge;
//import com.cloud.common.entity.UserJob;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class UserJobRepositoryTest {
//    @Autowired
//    UserJobRepository userJobRepository;
//
//    @Test
//    void insert() {
//        userJobRepository.save(UserJob.builder()
//                .code(1)
//                .content("관리자")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        userJobRepository.save(UserJob.builder()
//                .code(2)
//                .content("전문가 및 관련 종사자")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        userJobRepository.save(UserJob.builder()
//                .code(3)
//                .content("사무 종사자")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        userJobRepository.save(UserJob.builder()
//                .code(4)
//                .content("서비스 종사자")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        userJobRepository.save(UserJob.builder()
//                .code(5)
//                .content("판매 종사자")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        userJobRepository.save(UserJob.builder()
//                .code(6)
//                .content("농림ㆍ어업 숙련 종사자")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        userJobRepository.save(UserJob.builder()
//                .code(7)
//                .content("기능원 및 관련 기능 종사자")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        userJobRepository.save(UserJob.builder()
//                .code(8)
//                .content("장치ㆍ기계 조작 및 조립 종사자")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//        userJobRepository.save(UserJob.builder()
//                .code(9)
//                .content("단순노무 종사자")
//                .sortIdx(1)
//                .delYn(false)
//                .regId("yena")
//                .regDt(LocalDateTime.now())
//                .build());
//
//    }
//
//}
