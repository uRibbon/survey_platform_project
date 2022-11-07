package com.cloud.analysis.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Answer {
    @Id
    @Column(name = "ans_id")
    private Integer ansId;


}
