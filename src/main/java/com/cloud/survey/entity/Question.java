package com.cloud.survey.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
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
@EntityListeners(AuditingEntityListener.class)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="que_id", nullable = false)
    private int queId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sur_id", nullable = false)
    private Survey survey;

    @Column(name = "q_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private QuestionType qType;

    @Column(name="content", nullable = false, length = 50)
    private String content;

    @Column(name="reg_id", length = 20, nullable = false)
    private String regId;

    @Column(name = "reg_dt", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    private LocalDateTime regDt;

    @Column(name="mod_id", length = 20)
    private String modId;

    @Column(name = "mod_dt")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    private LocalDateTime modDt;
}
