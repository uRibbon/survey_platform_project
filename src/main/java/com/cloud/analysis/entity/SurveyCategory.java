package com.cloud.analysis.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(catalog = "common_db", name = "survey_category")
public class SurveyCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sur_cat_id", nullable = false)
    private Integer surCatId;

    @Column(name="content", length = 50, nullable = false)
    @NotNull
    private String content;
}
