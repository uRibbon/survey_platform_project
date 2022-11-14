package com.cloud.analysis.entity;

import com.cloud.analysis.entity.enums.TableType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
public class Analysis {
    @Id
    @Column(name = "analysis_id", nullable = false)
    private Integer analysisId;

    @Column(name = "sur_id", nullable = false)
    private Integer surveyId;

    @Column(length = 45, nullable = false)
    private String subject;
}
