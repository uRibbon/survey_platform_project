package com.cloud.survey.repository;

import com.cloud.survey.entity.IsYn;
import com.cloud.survey.entity.Survey;
import com.cloud.survey.entity.SurveyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {

    List<Survey> findByStatusAndIsPrivateYn(SurveyStatus status, IsYn isPrivateYn);
}
