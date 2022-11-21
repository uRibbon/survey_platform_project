package com.cloud.survey.repository;

import com.cloud.survey.entity.Answer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AnswerRepositoryTest {
    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Test
    void insert() {
        answerRepository.save(Answer.builder()
                .question(questionRepository.findById(1).orElse(null))
                .type(0)
                .content("1")
                .regId("young")
                .regDt(LocalDateTime.now())
                .build());
        answerRepository.save(Answer.builder()
                .question(questionRepository.findById(2).orElse(null))
                .type(0)
                .content("1")
                .regId("solbitest")
                .regDt(LocalDateTime.now())
                .build());
        answerRepository.save(Answer.builder()
                .question(questionRepository.findById(3).orElse(null))
                .type(0)
                .content("2")
                .regId("solbitest")
                .regDt(LocalDateTime.now())
                .build());
        answerRepository.save(Answer.builder()
                .question(questionRepository.findById(2).orElse(null))
                .type(0)
                .content("1")
                .regId("yuri")
                .regDt(LocalDateTime.now())
                .build());
        answerRepository.save(Answer.builder()
                .question(questionRepository.findById(3).orElse(null))
                .type(0)
                .content("3")
                .regId("yuri")
                .regDt(LocalDateTime.now())
                .build());
    }

}
