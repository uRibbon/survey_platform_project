package com.cloud.survey.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(catalog = "survey_db")
public class Survey {

        @Id
        @Column(name = "sur_id")
        private int surId;

        @Column(name="title", nullable = false, length = 50)
        private String title;

        @Column(name="description", nullable = false, length = 200)
        private String description;

        @Column(name = "category_id", nullable = false)
        private int category_id;

        @Column(name="version", nullable = false)
        private int version;

        @Column(name = "status", nullable = false)
        @Enumerated(EnumType.STRING)
        private SurveyStatus status;

        @Column(name = "due_dt", nullable = false)
        private LocalDateTime dueDt;

        @Column(name = "is_login", nullable = false)
        @Enumerated(EnumType.STRING)
        private IsYn isLoginYn;

        @Column(name = "is_private", nullable = false)
        @Enumerated(EnumType.STRING)
        private IsYn isPrivateYn;

        @Column(name = "is_modify", nullable = false)
        @Enumerated(EnumType.STRING)
        private IsYn isModifyYn;

        @Column(name = "is_annoy", nullable = false)
        @Enumerated(EnumType.STRING)
        private IsYn isAnnoyYn;

        @Column(name = "reg_id", nullable = false, length = 20)
        private String regId;

        @Column(name = "reg_dt", nullable = false)
        private LocalDateTime regDt;

        @Column(name = "mod_id", nullable = false, length = 20)
        private String ModId;

        @Column(name = "mod_dt", nullable = false)
        private LocalDateTime modDt;

}
