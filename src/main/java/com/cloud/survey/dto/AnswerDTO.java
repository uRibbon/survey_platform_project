package com.cloud.survey.dto;

import com.cloud.survey.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {

    private int ansId;
    private Question question;
    private int type;
    private String content;
    private String regId;
    private LocalDateTime regDt;

}
