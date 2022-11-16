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

    @Query("SELECT s FROM Survey s\n" +
            "WHERE s.views = (SELECT MAX(s.views) FROM Survey s " +
            "WHERE s.surveyCategory.surCatId = :surCatId)")
    Survey findBestSurveyByCategory(Integer surCatId);
}
