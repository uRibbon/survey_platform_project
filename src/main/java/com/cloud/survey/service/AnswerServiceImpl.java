package com.cloud.survey.service;

import com.cloud.survey.dto.AnswerDTO;
import com.cloud.survey.entity.Answer;
import com.cloud.survey.entity.Question;
import com.cloud.survey.repository.AnswerRepository;
import com.cloud.survey.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    @Override
    public Integer insertAnswer(AnswerDTO answerDTO) {
        Optional<Question> byId = questionRepository.findById(answerDTO.getQueId());
        if (byId.isPresent()) {
            Question question = byId.get();
            Answer save = answerRepository.save(dtoToEntity(answerDTO, question));
            if (save != null) {
                return save.getAnsId();
            } else {
                log.error("답변 저장 실패");
            }
        } else{
            log.error("질문 조회 실패");
        }
        return null;
    }

    @Override
    public Integer updateAnswer(AnswerDTO answerDTO) {
        Optional<Answer> byId = answerRepository.findById(answerDTO.getAnsId());
        if (byId.isPresent()) {
            Answer answer = byId.get();
            answer.changeContent(answer.getContent());
            answer.changeModId(answer.getModId());
            Answer save = answerRepository.save(answer);
            if (save != null) {
                return save.getAnsId();
            }
        } else {
            log.error("findById 오류로 답변 변경 실패");
        }
        return null;
    }

    @Override
    public void deleteAnswer(Integer answerId) {
        Optional<Answer> byId = answerRepository.findById(answerId);
        if (byId.isPresent()) {
            answerRepository.updateDeleteYn(answerId);
        } else {
            log.error("findById 오류로 답변 삭제 실패");
        }
    }
}
