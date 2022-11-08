package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Answer;
import com.cloud.analysis.entity.enums.Type;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@NoArgsConstructor
class AnswerRepositoryTest {
    @Autowired
    AnswerRepository answerRepository;
    @Test
    public void read(){
        List<Answer> answerList = answerRepository.findAll();
        answerList.forEach(answer -> {
            Pattern pattern = Pattern.compile("([a-zA-Z]+)");
            Matcher matcher = pattern.matcher(answer.getContent());
            while(matcher.find()){
                System.out.println(matcher.group());
            }

            System.out.println("answer = " + answer);
        });
    }

    @Test
    public void insert(){
        Answer answer = Answer.builder()
                .ansId(2)
                .type(Type.Member)
                .regId("2")
                .regIp("123123")
                .regDt(LocalDateTime.now())
                .modId("123123122")
                .modDt(LocalDateTime.now())
                .surId(1233)
                .queId(595959)
                .content("[\"young\",\"Joo\"]")
                .build();
        answerRepository.save(answer);
    }



}