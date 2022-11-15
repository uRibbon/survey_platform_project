package com.cloud.survey.entity;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ans_id")
    private int ansId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "que_id", insertable=false, updatable=false)
    private Question question;

    @NotNull
    @Column(name = "type")
    private int type;

    @NotNull
    @Column(name = "content", length = 50)
    private String content;

    @NotNull
    @Column(name = "reg_id")
    private String regId;

//    @NotNull
    @Column(name = "reg_ip", length = 50)
    private String regIp;

    @NotNull
    @Column(name = "reg_dt")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 20)
    private String modId;

    @Column(name = "mod_dt")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    private LocalDateTime modDt;

    @ColumnDefault("false")
    private Boolean delYn;


    public void changeContent(String content) {
        this.content = content;
    }

    public void changeModId(String modId) {
        this.modId = modId;
    }

}
