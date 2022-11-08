package com.cloud.analysis.entity;
import com.cloud.analysis.entity.enums.Type;
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
public class Answer {
    @Id
    @Column(name = "ans_id")
    private Integer ansId;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "reg_id", nullable = false, length = 20)
    private String regId;

    @Column(name = "reg_ip", nullable = false, length = 50)
    private String regIp;

    @Column(name = "reg_dt", nullable = false)
    private LocalDateTime regDt;

    @Column(name = "mod_id", nullable = false, length = 20)
    private String modId;

    @Column(name = "mod_dt", nullable = false)
    private LocalDateTime modDt;

    @Column(name = "sur_id", nullable = false)
    private Integer surId;

    @Column(name = "que_id", nullable = false)
    private Integer queId;

    @Column(name = "content", length = 50, nullable = false)
    private String content;

}
