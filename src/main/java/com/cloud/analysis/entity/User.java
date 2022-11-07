package com.cloud.analysis.entity;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @CreationTimestamp
    @Column(name = "reg_dt")
    @NotNull
    private LocalDateTime regDt;

    @Column(name = "reg_id", length = 20)
    @NotNull
    private String regId;

    @Column(name = "user_pwd", length = 50)
    @NotNull
    private String userPwd;

    @Column(name = "mail_addr", length = 30)
    @NotNull
    private String mailAddr;

    @Column(name = "phonw", length = 11)
    @NotNull
    private String phonw;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @NotNull
    private role role;

    public enum role{
        Admin, Manager, Member, Non_member
    }

    @Column(name = "name", length = 30)
    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_mail_accept")
    @NotNull
    private isMailAccept isMailAccept;

    public enum isMailAccept{
        Y, N
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "is_phone_accept")
    @NotNull
    private isPhoneAccept isPhoneAccept;

    public enum isPhoneAccept{
        Y, N
    }

    @Column(name = "age")
    @NotNull
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    @NotNull
    private gender gender;

    public enum gender{
        M, F
    }

    @Column(name = "job", length = 30)
    @NotNull
    private String job;


}
