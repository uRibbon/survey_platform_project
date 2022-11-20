package com.cloud.survey.controller;

import com.cloud.survey.dto.AnswerDTO;
import com.cloud.survey.dto.AnswerResponseDTO;
import com.cloud.survey.entity.Answer;
import com.cloud.survey.service.AnswerService;
import com.cloud.survey.service.kafka.producer.KafkaProducer;
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

    @Autowired
    private KafkaProducer kafkaProducer;


    // 사용자의 답변 조회
    @RequestMapping(value = "/user_answer", method = RequestMethod.POST)
    public ResponseEntity<List<Map<String,Object>>> getSurveyAnswer(@RequestParam(value = "user_id") String userId, @RequestParam(value = "sur_id") int surId) {
        return new ResponseEntity<>(answerService.getUserAnswer(userId, surId), HttpStatus.OK);
    }

    // 답변 등록
    @PostMapping("/reg")
    public ResponseEntity<String> registerAnswer(@RequestBody(required = false) AnswerResponseDTO answerResponseDTO) {
        Integer surId = answerResponseDTO.getSurId();
        List<AnswerDTO> answerDTOList = answerResponseDTO.getAnswerDTOList();
        answerService.insertAnswer(surId, answerDTOList);

        // kafka 토픽 생성
//        Map<String, Object> map = new HashMap<>();
//        map.put("sur_id", sur_id);
//        map.put("analysis", answerService.getSurveyAnswerAnalysis(surId));
//        kafkaProducer.sendObject("registerAnswer", map);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    // 답변 수정
    @PostMapping("/mod")
    public ResponseEntity<String> modifyAnswer(@RequestBody(required = false) AnswerResponseDTO answerResponseDTO) {
        Integer surId = answerResponseDTO.getSurId();
        List<AnswerDTO> answerDTOList = answerResponseDTO.getAnswerDTOList();
        answerService.updateAnswer(surId, answerDTOList);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    // 답변 삭제
    @PostMapping("/del")
    public ResponseEntity<String> removeAnswer(@RequestParam(value = "ansId") Integer ansId) {
        // ansId 필요
        answerService.deleteAnswer(ansId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
