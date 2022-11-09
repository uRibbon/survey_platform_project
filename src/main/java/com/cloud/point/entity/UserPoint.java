package com.cloud.point.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_point")
public class UserPoint {

    @Id
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="user_id", length = 20, nullable = false)
    private String userId;

    @Column(name="user_point_score")
    private Integer userPointScore;
}
