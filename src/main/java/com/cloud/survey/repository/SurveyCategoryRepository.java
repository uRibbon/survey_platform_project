package com.cloud.survey.repository;

import com.cloud.survey.entity.SurveyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SurveyCategoryRepository extends JpaRepository<SurveyCategory, Integer> {

    SurveyCategory findBySurCatId(@Param("sur_cat_id") Integer surCatId);

}
