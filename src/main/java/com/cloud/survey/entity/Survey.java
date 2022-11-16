package com.cloud.survey.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Survey {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "sur_id", nullable = false)
        private int surId;

        @Column(name="title", nullable = false, length = 50)
        private String title;

        @Column(name="description", nullable = false, length = 200)
        private String description;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "category_id", nullable = false)
        private SurveyCategory surveyCategory;

        @Column(name="version", nullable = false)
        private int version;

        @Column(name = "status", nullable = false)
        @Enumerated(EnumType.STRING)
        private SurveyStatus status;

        @Column(name = "due_dt", nullable = false)
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime dueDt;

        @ColumnDefault("0")
        private Integer views;

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

        @CreatedDate
        @Column(name = "reg_dt", nullable = false)
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime regDt;

        @Column(name = "mod_id", length = 20)
        private String ModId;

        @LastModifiedDate
        @Column(name = "mod_dt")
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime modDt;

}
