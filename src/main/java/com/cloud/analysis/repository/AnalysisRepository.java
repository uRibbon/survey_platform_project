package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnalysisRepository extends JpaRepository<Analysis, Integer> {

    // 설문 응답자 연령별 비율
    @Query("select * from analysis A join analysis_option AO on A.analysis_id = AO.analysis_id where A.analysis_id = :analysisId")
    List<Object[]> findAnswerByAge(Integer analysisId);
}
