package com.cloud.survey.service;

import com.cloud.survey.dto.question.QuestionDTO;
import com.cloud.survey.entity.Question;
import com.cloud.survey.entity.QuestionOption;
import com.cloud.survey.repository.QuestionOptionRepository;
import com.cloud.survey.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private final QuestionRepository questionRepository;

    @Autowired
    private final QuestionOptionRepository questionOptionRepository;

    @Transactional
    public List<QuestionDTO> getSurveyQuestion (int surId){
        List<QuestionDTO> questionDtoList = new ArrayList<>();
        List<Question> questionList = questionRepository.findBySurId(surId);

        questionList.forEach(question -> {
            List<QuestionOption> questionOptionList = questionOptionRepository.findQuestionOptionByQueId(question.getQueId());
            QuestionDTO questionDTO = dtoToEntity(question, questionOptionList);
            questionDtoList.add(questionDTO);
        });

        return questionDtoList;
    }
}
