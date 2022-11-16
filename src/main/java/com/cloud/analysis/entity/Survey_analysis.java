package com.cloud.analysis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
public class Survey_analysis {
    @Id
    @Column(name = "analysis_id", nullable = false)
    private Integer analysisId;

    @Column(name = "sur_id", nullable = false)
    private Integer surveyId;

    @Column(length = 45, nullable = false)
    private String subject;

    @Column(name = "reg_dt", nullable = false)
    private LocalDateTime regDt;

    @Column(name = "reg_id", nullable = false, length = 20)
    private String regId;
}
