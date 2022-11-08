package com.cloud.point.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="point_type")
public class PointType {
    @Id
    @Column(name="no", nullable = false)
    private int no;

    @Column(name="type", length = 5, nullable = false)
    private String type;

    @Column(name="score", nullable = false)
    private int score;

    @Column(name="reg_id", length = 20, nullable = false)
    private String regId;

    @Column(name="reg_dt", nullable = false)
    private LocalDateTime regDt;

    @Column(name="mod_id", length = 20)
    private String modId;

    @Column(name="mod_dt")
    private LocalDateTime modDt;
}

