package com.cloud.analysis.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "survey_category")

public class SurveyCategory {
    @Id
    @Column(name="sur_cat_id")
    @NotNull
    private Integer surCatId;

    @Column(name="content", length = 50)
    @NotNull
    private String content;
}
