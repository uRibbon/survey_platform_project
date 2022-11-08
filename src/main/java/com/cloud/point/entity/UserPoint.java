package com.cloud.point.entity;

import javax.persistence.*;

@Entity
@Table(name="user_point")
public class UserPoint {
    @Id
    @Column(name="user_id", length = 20, nullable = false)
    private String userId;

    @Column(name="user_point_score", nullable = false)
    private int userPointScore;
}
