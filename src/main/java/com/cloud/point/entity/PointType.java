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
@Table(name="point_type")
public class PointType {
    @Id
    @Column(name="no", length=10, nullable = false)
    private Integer no;

    @Column(name="type", length = 5, nullable = false)
    private String type;

    @Column(name="score", length = 10, nullable = false)
    private Integer score;

    @Column(name="reg_id", length = 20, nullable = false)
    private String regId;

    @Column(name="reg_dt", nullable = false)
    private LocalDateTime regDt;

    @Column(name="mod_id", length = 20)
    private String modId;

    @Column(name="mod_dt")
    private LocalDateTime modDt;
}

