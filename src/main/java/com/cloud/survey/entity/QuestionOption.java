package com.cloud.survey.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionOption {
    @Id
    @Column(name = "que_opt_id", length = 10, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer queOptId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "que_id", nullable = false)
    private Question question;

    @Column(name = "option_order", length = 10, nullable = false)
    private Integer optionOrder;

    @Column(name = "option_name", length = 50, nullable = false)
    private String optionName;


}
