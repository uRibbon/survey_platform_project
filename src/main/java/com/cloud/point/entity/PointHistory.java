package com.cloud.point.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="point_history")
public class PointHistory {
    @Id
    @Column(name = "point_his_no", nullable = false)
    private int pointHisNo;

    @Column(name = "user_id", length = 20, nullable = false)
    private String userId;

    @Column(name = "type_no", nullable = false)
    private int typeNo;

    @Column(name = "reg_id", length = 20, nullable = false)
    private String regId;

    @Column(name = "reg_dt", nullable = false)
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 20)
    private String modId;

    @Column(name = "mod_dt")
    private LocalDateTime modDt;
}
