package com.cloud.survey.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ans_id", nullable = false)
    private int ansId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "que_id", nullable = false)
    private Question question;

    @Column(name = "type", nullable = false)
    private int type;

    @Column(name = "content", length = 50, nullable = false)
    private String content;

    @Column(name = "reg_id", nullable = false)
    private String regId;

    @Column(name = "reg_ip", length = 50)
    private String regIp;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    @Column(name = "reg_dt", nullable = false)
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 20)
    private String modId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    @Column(name = "mod_dt")
    private LocalDateTime modDt;

    @ColumnDefault("false")
    @Column(name = "del_yn")
    private Boolean delYn;

    public void changeContent(String content) {
        this.content = content;
    }

    public void changeModId(String modId) {
        this.modId = modId;
    }

}
