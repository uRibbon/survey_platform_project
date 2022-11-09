package com.cloud.point.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="point_history")
public class PointHistory {
    @Id
    @Column(name = "point_his_no", nullable = false)
    private int pointHisNo;

    @Column(name = "user_id", length = 20, nullable = false)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "type_no", nullable = false)
    private PointType pointType;

    @Column(name = "reg_id", length = 20, nullable = false)
    private String regId;

    @Column(name = "reg_dt", nullable = false)
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 20)
    private String modId;

    @Column(name = "mod_dt")
    private LocalDateTime modDt;
}
