package com.cloud.analysis.entity;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.EnumSet;

@Entity
public class Answer {
    @Id
    @Column(name = "ans_id")
    @NotNull
    private Integer ansId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    @NotNull
    private type type;

    public enum type{
        Member, Non_member
    }

    @Column(name = "reg_id", length = 20)
    @NotNull
    private String regId;

    @Column(name = "reg_ip", length = 50)
    @NotNull
    private String regIp;

    @CreationTimestamp
    @Column(name = "reg_dt")
    @NotNull
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 20)
    @NotNull
    private String modId;

    @CreationTimestamp
    @Column(name = "mod_dt")
    @NotNull
    private LocalDateTime modDt;

    @Column(name = "sur_id")
    @NotNull
    private Integer surId;

    @Column(name = "que_id")
    @NotNull
    private Integer queId;

    @Column(name = "content")
    private EnumSet<Content> content;

    public enum Content {
        Value_A,Value_B
    }

}
