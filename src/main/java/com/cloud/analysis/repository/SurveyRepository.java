package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Menu;
import com.cloud.analysis.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
    // 카테고리별 설문 개수
    @Query("select s.surveyCategory.content, count(s) from Survey s group by s.surveyCategory")
    List<Object[]> findSurveyCntByCategory();

}
