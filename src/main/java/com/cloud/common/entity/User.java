package com.cloud.common.entity;
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
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_pwd", nullable = false)
    private String userPwd;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String job;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Boolean gender;

    @Column(nullable = false)
    private String phone;

    @Column(name = "mail_addr", nullable = false)
    private String mailAddr;

    @Column(name = "is_mail_accept", nullable = false)
    private Boolean isMailAccept;

    @Column(name = "is_phone_accpept", nullable = false)
    private Boolean isPhoneAccept;

    @Column(nullable = false)
    private Role role;

    @Column(name = "reg_id", nullable = false)
    private String regId;

    @Column(name = "reg_dt", nullable = false)
    private LocalDateTime regDt;

    @Column(name = "use_yn", nullable = false)
    private Boolean useYn;

}
