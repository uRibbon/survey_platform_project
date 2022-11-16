package com.cloud.survey.repository;

import com.cloud.survey.entity.QuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionOptionRepository extends JpaRepository<QuestionOption, Integer> {
}
