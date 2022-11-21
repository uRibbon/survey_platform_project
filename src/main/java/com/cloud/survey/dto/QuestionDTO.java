package com.cloud.survey.dto;

import com.cloud.survey.entity.QuestionOption;
import com.cloud.survey.entity.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionDTO {

    private int queId;
    private int surId;
    private QuestionType qType;
    private String content;
    private List<QuestionOption> optionList;

    public void addOptionList(QuestionOption questionOption) {
        optionList.add(questionOption);
    }

}
