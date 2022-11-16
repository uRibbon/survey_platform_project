package com.cloud.analysis.repository;
import com.cloud.analysis.entity.Survey_analysis;
//import com.cloud.analysis.entity.enums.TableType;
import com.cloud.analysis.service.AnalysisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AnalysisRepositoryTest {
    @Autowired
    AnalysisRepository analysisRepository;

    @Autowired
    private AnalysisService analysisService;

    @Test
    void read() {
        List<Survey_analysis> analysisList = analysisRepository.findAll();
        analysisList.forEach(analysis -> {
            System.out.println("analysis.toString() = " + analysis.toString());
        });
    }

}
