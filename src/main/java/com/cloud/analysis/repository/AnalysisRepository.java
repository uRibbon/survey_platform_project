package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Analysis;
import com.cloud.analysis.entity.Analysis_option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnalysisRepository extends JpaRepository<Analysis, Integer> {

    // 설문 응답자 연령별 비율
    @Query("select AO from Analysis A join Analysis_option AO on A.analysisId = AO.analysisId.analysisId where A.analysisId = :analysisId")
    List<Analysis_option> findAnswerByAge(Integer analysisId);
}
