package com.cloud.survey.controller;

import com.cloud.survey.dto.AnswerDTO;
import com.cloud.survey.entity.Answer;
import com.cloud.survey.service.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(value="v1/answer")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping("/reg")
    public ResponseEntity<String> registerAnswer(AnswerDTO answerDTO) {
        // queId, type, content, regId 필요
        answerService.insertAnswer(answerDTO);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/mod")
    public ResponseEntity<String> modifyAnswer(AnswerDTO answerDTO) {
        // ansId, content, regId 필요
        answerService.updateAnswer(answerDTO);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/del/{ansId}")
    public ResponseEntity<String> removeAnswer(@PathVariable Integer ansId) {
        // ansId 필요
        answerService.deleteAnswer(ansId);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
