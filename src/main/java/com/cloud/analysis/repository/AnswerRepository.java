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
    // 서베이에 참여한 유저 리스트 출력
    @Query("select a.user from Answer a where a.survey.surId = :surId")
    List<User> findAnswerBySurvey(Integer surId);

    // 유저가 작성한 답안 리스트 출력
    @Query("select a from Answer a where a.user.regId = :userId")
    List<Answer> findAnswerByUser(String userId);

    @Query("select a.content, count(a.content) from Answer a join User u on a.user = u where u.gender = :gender")
    Map<String, Integer> findAnswerByGender(Boolean gender);

    @Query("select a.content, count(a.content) from Answer a join User u on a.user = u where u.age = :age")
    Map<String, Integer> findAnswerByAge(int age);

    @Query("select a.content, count(a.content) from Answer a join User u on a.user = u where u.job = :job")
    Map<String, Integer> findAnswerByJob(String job);
}
