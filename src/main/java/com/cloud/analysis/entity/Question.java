package com.cloud.analysis.entity;

import com.cloud.analysis.entity.enums.QType;
import com.cloud.analysis.entity.enums.YesOrNo;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(catalog = "common_db")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="que_id")
    private Integer queId;

    @Column(name="content", length = 50)
    @NotNull
    private String content;

    @Column(name = "q_type")
    @Enumerated(EnumType.STRING)
    @NotNull
    private QType qType;

    @Column(name = "is_private")
    @Enumerated(EnumType.STRING)
    @NotNull
    private YesOrNo isPrivate;

    @Column(name="reg_id", length = 20)
    @NotNull
    private String regId;

    @Column(name = "reg_dt")
    @NotNull
    private LocalDateTime regDt;

    @Column(name="mod_id", length = 20)
    @NotNull
    private String modId;

    @Column(name = "mod_dt")
    @NotNull
    private LocalDateTime modDt;
}
