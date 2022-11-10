package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Menu;
import com.cloud.analysis.entity.Question;
import com.cloud.analysis.entity.enums.QType;
import com.cloud.analysis.entity.enums.YesOrNo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
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

    @Test
    void insert() {
        Question question = Question.builder()
                .content("가장 좋아하는 음식은?")
                .qType(QType.Grd)
                .isPrivate(YesOrNo.Y)
                .regId("yena")
                .regDt(LocalDateTime.now())
                .modId("yena")
                .modDt(LocalDateTime.now())
                .build();
        questionRepository.save(question);
    }
}
