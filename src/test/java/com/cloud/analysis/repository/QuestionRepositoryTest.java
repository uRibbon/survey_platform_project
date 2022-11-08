package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Menu;
import com.cloud.analysis.entity.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class QuestionRepositoryTest {
    @Autowired
    QuestionRepository questionRepository;

    @Test
    void read(){
        List<Question> questionList = questionRepository.findAll();
        questionList.forEach(question -> {
            System.out.println("question = " + question);
        });
    }
}