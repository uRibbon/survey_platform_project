package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Survey_analysis;
import com.cloud.analysis.entity.Survey_analysis_option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnalysisRepository extends JpaRepository<Survey_analysis, Integer> {

    // 설문 응답자 연령별 비율
    @Query("select SAO from Survey_analysis SA join Survey_analysis_option SAO on SA.analysisId = SAO.analysisId.analysisId where SA.analysisId = :analysisId")
    List<Survey_analysis_option> findAnalysisByColumn(Integer analysisId);
}
