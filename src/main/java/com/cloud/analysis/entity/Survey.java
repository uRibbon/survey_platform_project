package com.cloud.analysis.entity;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
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

    @Column(name = "category_id")
    @NotNull
    private Integer categoryId;

    @Column(name = "version")
    @NotNull
    private Float version;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @NotNull
    private status status;

    public enum status{
        proc, end
    }

    @CreationTimestamp
    @Column(name = "due_dt")
    @NotNull
    private LocalDateTime dueDt;

    @Column(name = "group_id")
    @NotNull
    private Integer groupId;

    @Column(name = "reg_id", length = 20)
    @NotNull
    private String regId;

    @CreationTimestamp
    @Column(name = "reg_dt")
    @NotNull
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 20)
    private String modId;

    @CreationTimestamp
    @Column(name = "mod_dt")
    private LocalDateTime modDt;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_login")
    @NotNull
    private isLogin isLogin;

    public enum isLogin{
        Y, N
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "is_private")
    @NotNull
    private isPrivate isPrivate;

    public enum isPrivate{
        Y, N
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "is_modify")
    @NotNull
    private isModify isModify;

    public enum isModify{
        Y, N
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "is_annoy")
    @NotNull
    private isAnnoy isAnnoy;

    public enum isAnnoy{
        Y, N
    }
}