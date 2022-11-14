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
    // 설문에 속한 질문
    // SELECT * FROM question q WHERE q.sur_id = 1

    // 설문에 참여한 전체 응답자
    @Query("select a.user from Answer a where a.survey.surId = :surId")
    List<User> findAnswerBySurvey(Integer surId);

    // 응답자가 작성한 모든 답변
    // surId 추가로 필요함
    @Query("select a from Answer a where a.user.regId = :userId")
    List<Answer> findAnswerByUser(String userId);

    // 월별 설문 등록
    // SELECT month(s.reg_dt), COUNT(*) FROM survey s GROUP BY month(s.reg_dt)

    // 설문 응답자 연령별 비율
    @Query("select u.age, count(u) from Answer a join User u on a.user = u where a.survey.surId = :surId group by u.age")
    List<Object[]> findAnswerByAge(Integer surId);

    // 설문 응답자 직업
    @Query("select u.job, count(u) from Answer a join User u on a.user = u where a.survey.surId = :surId group by u.job")
    List<Object[]> findAnswerByJob(Integer surId);

    // 설문 응답자 남녀 사용자 비율
    @Query("select u.gender, count(u) from Answer a join User u on a.user = u where a.survey.surId = :surId group by u.gender")
    List<Object[]> findAnswerByGender(Integer surId);

    // 설문 응답 시간대
    // SELECT hour(a.reg_dt), COUNT(*) FROM answer a WHERE a.sur_id = 1 GROUP BY hour(a.reg_dt)
}
