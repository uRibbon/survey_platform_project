package com.cloud.survey.repository;

import com.cloud.survey.entity.IsYn;
import com.cloud.survey.entity.Survey;
import com.cloud.survey.entity.SurveyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Column;
import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {

    List<Survey> findByStatusAndIsPrivateYn(SurveyStatus status, IsYn isPrivateYn);
    Survey findBySurId(int surId);

    @Query(value = "SELECT * FROM survey \n" +
            "WHERE views = (SELECT MAX(views) FROM survey WHERE category_id = :surCatId)\n" +
            "ORDER BY reg_dt DESC LIMIT 1;", nativeQuery = true)
    Survey findBestSurveyByCategory(Integer surCatId);
}
