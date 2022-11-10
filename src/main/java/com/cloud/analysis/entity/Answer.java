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
@Table(catalog = "common_db")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ans_id")
    private Integer ansId;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "reg_id")
    private User user;

    @Column(name = "reg_ip", nullable = false, length = 50)
    private String regIp;

    @Column(name = "reg_dt", nullable = false)
    private LocalDateTime regDt;

    @Column(name = "mod_id", nullable = false, length = 20)
    private String modId;

    @Column(name = "mod_dt", nullable = false)
    private LocalDateTime modDt;

    @ManyToOne
    @JoinColumn(name = "sur_id")
    private Survey survey;

//    @Column(name = "que_id", nullable = false)
    @ManyToOne
    @JoinColumn(name = "que_id")
    private Question question;

    @Column(name = "content", length = 50, nullable = false)
    private String content;
}
