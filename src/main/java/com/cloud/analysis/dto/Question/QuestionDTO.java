package com.cloud.analysis.dto.Question;

import com.cloud.analysis.entity.Question.QuestionOption;
import com.cloud.analysis.entity.Question.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionDTO {

    private int queId;
    private int surId;
    private QuestionType questionType;
    private String content;
    private List<QuestionOption> optionList;

    public void addOptionList(QuestionOption questionOption) {
        optionList.add(questionOption);
    }

}
