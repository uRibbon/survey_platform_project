package com.cloud.survey.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="que_id")
    private int queId;

    @Column(name="sur_id")
    private int surId;

    @NotNull
    @Column(name = "q_type")
    @Enumerated(EnumType.STRING)
    private QuestionType qType;

    @NotNull
    @Column(name="content", nullable = false, length = 50)
    private String content;

    @NotNull
    @Column(name="reg_id", length = 20)
    private String regId;

    @NotNull
    @Column(name = "reg_dt")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;

    @Column(name="mod_id", length = 20)
    private String modId;

    @Column(name = "mod_dt")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modDt;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

}
