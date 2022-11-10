package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Analysis;
import com.cloud.analysis.entity.Answer;
import com.cloud.analysis.entity.Survey;
import com.cloud.analysis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
    @Query("select a.user from Answer a where a.survey.surId = :surId")
    List<User> findAnswerBySurvey(Integer surId);

    @Query("select a from Answer a where a.user.regId = :userId")
    List<Answer> findAnswerByUser(String userId);

    @Query("select a.content, count(a.content) from Answer a join User u on a.user = u where u.gender = :gender")
    Map<String, Integer> findAnswerByGender(Boolean gender);

    @Query("select a.content, count(a.content) from Answer a join User u on a.user = u where u.age = :age")
    Map<String, Integer> findAnswerByAge(int age);

    @Query("select a.content, count(a.content) from Answer a join User u on a.user = u where u.job = :job")
    Map<String, Integer> findAnswerByJob(String job);
}
