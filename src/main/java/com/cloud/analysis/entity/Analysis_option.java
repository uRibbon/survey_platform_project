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
public class Analysis_option {
    @Id
    @Column(name = "option_id", nullable = false)
    private Integer optionId;

    @ManyToOne
    @JoinColumn(name = "analysis_id")
    private Analysis analysisId;

    @Column(name = "option_name", nullable = false)
    private Integer optionName;

    @Column(nullable = false)
    private Integer value;
}
