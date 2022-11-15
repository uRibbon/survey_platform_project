package com.cloud.survey.repository;

import com.cloud.survey.entity.Answer;
import com.cloud.survey.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    @Query(value = "select a.ans_id, a.que_id, a.type, a.content, qo.option_name, date_format(a.reg_dt, '%Y-%m-%d %H:%i:%S') reg_dt, a.reg_ip, q.sur_id, q.q_type, q.content question" +
            " from answer a left outer join question_option qo on a.que_id = qo.que_id and a.content = qo.option_order " +
            "left outer join question q on a.que_id = q.que_id WHERE a.reg_id =:userId and q.sur_id = :surId", nativeQuery=true)
    List<Map<String,Object>> findByRegIdAndSurId(@Param("userId") String userId, @Param("surId") int surId);

    @Query("update Answer a set a.delYn = true where a.ansId = :ansId")
    void updateDeleteYn(Integer ansId);

}
