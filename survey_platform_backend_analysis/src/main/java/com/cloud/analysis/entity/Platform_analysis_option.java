package com.cloud.analysis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Platform_analysis_option {
    @Id
    @Column(name = "option_id", nullable = false)
    private Integer optionId;

    @ManyToOne
    @JoinColumn(name = "platform_analysis_id")
    private Platform_analysis platformAnalysisId;

    @Column(name = "option_name", nullable = false)
    private String optionName;

    @Column(nullable = false)
    private Integer value;
}
