package com.cloud.analysis.entity;
import com.cloud.analysis.entity.enums.Status;
import com.cloud.analysis.entity.enums.YesOrNo;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"survey_category"})
public class Survey {
    @Id
    @Column(name = "sur_id")
    @NotNull
    private Integer surId;

    @Column(name = "title", length = 50)
    @NotNull
    private String title;

    @Column(name = "details", length = 200)
    @NotNull
    private String details;

//    @Column(name = "category_id")
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private SurveyCategory surveyCategory;

    @Column(name = "version")
    @NotNull
    private Float version;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;

    @Column(name = "due_dt")
    @NotNull
    private LocalDateTime dueDt;

    @Column(name = "group_id")
    @NotNull
    private Integer groupId;

    @Column(name = "reg_id", length = 20)
    @NotNull
    private String regId;

    @Column(name = "reg_dt")
    @NotNull
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 20)
    private String modId;

    @Column(name = "mod_dt")
    private LocalDateTime modDt;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_login")
    @NotNull
    private YesOrNo isLogin;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_private")
    @NotNull
    private YesOrNo isPrivate;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_modify")
    @NotNull
    private YesOrNo isModify;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_annoy")
    @NotNull
    private YesOrNo isAnnoy;
}