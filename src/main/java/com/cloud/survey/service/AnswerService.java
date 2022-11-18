package com.cloud.survey.service;

import com.cloud.survey.dto.AnswerDTO;
import com.cloud.survey.entity.Answer;
import com.cloud.survey.entity.Question;
import com.cloud.survey.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

public interface AnswerService {

    List<Map<String,Object>> getUserAnswer (String userId, int surId); // 사용자의 답변 조회

    Integer insertAnswer(AnswerDTO answerDTO);
    Integer updateAnswer(AnswerDTO answerDTO);
    void deleteAnswer(Integer answerId);

    default Answer dtoToEntity(AnswerDTO dto, Question question) {
        Answer answer = Answer.builder()
                .question(question)
                .type(dto.getType())
                .content(dto.getContent())
                .regId(dto.getRegId())
                .build();
        return answer;
    }

    default AnswerDTO entityToDTO(Answer answer) {
        AnswerDTO dto = AnswerDTO.builder()
                .ansId(answer.getAnsId())
                .queId(answer.getQuestion().getQueId())
                .type(answer.getType())
                .content(answer.getContent())
                .regId(answer.getRegId())
                .build();
        return dto;
    }
}
