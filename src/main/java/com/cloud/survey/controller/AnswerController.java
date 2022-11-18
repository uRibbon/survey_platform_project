package com.cloud.survey.controller;

import com.cloud.survey.dto.AnswerDTO;
import com.cloud.survey.entity.Answer;
import com.cloud.survey.service.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping(value="v1/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;


    // 사용자의 답변 조회
    @RequestMapping(value = "/user_answer", method = RequestMethod.POST)
    public ResponseEntity<List<Map<String,Object>>> getSurveyAnswer(@RequestParam(value = "user_id") String userId, @RequestParam(value = "sur_id") int surId) {
        return new ResponseEntity<>(answerService.getUserAnswer(userId, surId), HttpStatus.OK);
    }

    // 답변 등록
    @PostMapping("/reg")
    public ResponseEntity<String> registerAnswer(AnswerDTO answerDTO) {
        // queId, type, content, regId 필요
        answerService.insertAnswer(answerDTO);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    // 답변 수정
    @PostMapping("/mod")
    public ResponseEntity<String> modifyAnswer(AnswerDTO answerDTO) {
        // ansId, content, regId 필요
        answerService.updateAnswer(answerDTO);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    // 답변 삭제
    @GetMapping("/del/{ansId}")
    public ResponseEntity<String> removeAnswer(@PathVariable Integer ansId) {
        // ansId 필요
        answerService.deleteAnswer(ansId);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
