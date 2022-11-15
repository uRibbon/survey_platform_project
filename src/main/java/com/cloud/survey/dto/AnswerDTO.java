package com.cloud.survey.dto;

import com.cloud.survey.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {

    private int ansId;
    private int queId;
    private int type;
    private String content;
    private String regId;

}
