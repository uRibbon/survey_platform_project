package com.cloud.survey.repository;

import com.cloud.survey.entity.SurveyCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyCategoryRepository extends JpaRepository<SurveyCategory, Integer> {
}
