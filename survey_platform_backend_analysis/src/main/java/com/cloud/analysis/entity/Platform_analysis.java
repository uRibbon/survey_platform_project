package com.cloud.analysis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
public class Platform_analysis {
    @Id
    @Column(name = "platform_analysis_id", nullable = false)
    private Integer platformAnalysisId;

    @Column(name = "sur_id", nullable = false)
    private Integer surveyId;

    @Column(length = 45, nullable = false)
    private String subject;

    @Column(name = "reg_dt", nullable = false)
    private LocalDateTime regDt;

    @Column(name = "reg_id", nullable = false, length = 20)
    private String regId;

    @Column(nullable = false)
    private Integer type;
}
