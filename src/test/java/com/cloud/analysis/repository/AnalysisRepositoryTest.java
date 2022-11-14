package com.cloud.analysis.repository;
import com.cloud.analysis.entity.Analysis;
//import com.cloud.analysis.entity.enums.TableType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AnalysisRepositoryTest {
    @Autowired
    AnalysisRepository analysisRepository;

    @Test
    void read() {
        List<Analysis> analysisList = analysisRepository.findAll();
        analysisList.forEach(analysis -> {
            System.out.println("analysis.toString() = " + analysis.toString());
        });
    }

//    @Test
//    void read2() {
//        List<Object> AllAnalysisList = new ArrayList<>();
//        List<Object[]> analysisList = analysisRepository.findAnswerByAge(1);
//        AllAnalysisList.add(analysisList);
//        System.out.println(AllAnalysisList);
//    }

//    @Test
//    void insert() {
//        Analysis analysis = Analysis.builder()
//                .analysisId(1)
//                .tableType(TableType.BAR)
//                .build();
//        analysisRepository.save(analysis);
//    }
}
