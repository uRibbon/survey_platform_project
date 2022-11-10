package com.cloud.analysis.entity;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "table_type")
    private TableType tableType;

    @Column(length = 45)
    private String subject;

    @Column(length = 45)
    private String value;

    @Column(name = "x_axis", length = 45)
    private String xAxis;

    @Column(name = "y_axis", length = 45)
    private String yAxis;
}
