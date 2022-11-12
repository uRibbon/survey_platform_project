package com.cloud.survey.repository;

import com.cloud.survey.entity.IsYn;
import com.cloud.survey.entity.Question;
import com.cloud.survey.entity.Survey;
import com.cloud.survey.entity.SurveyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findBySurId(int surId);


}
