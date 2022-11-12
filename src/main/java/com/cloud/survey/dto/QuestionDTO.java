package com.cloud.survey.dto;

import com.cloud.survey.entity.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

    private int queId;
    private int surId;
    private QuestionType qType;
    private String content;

}
