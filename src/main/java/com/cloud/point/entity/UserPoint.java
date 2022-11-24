package com.cloud.point.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(catalog = "point_db", name="user_point")
public class UserPoint {

    @Id
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="user_id", length = 20, nullable = false)
    private String userId;

    @Column(name="user_point_score")
    private Integer userPointScore;

    public void UpdateUserName(String userId) {
        this.userId = userId;
    }
    public void UpdateUserPointScore(Integer userPointScore) {
        this.userPointScore = userPointScore;
    }
}
