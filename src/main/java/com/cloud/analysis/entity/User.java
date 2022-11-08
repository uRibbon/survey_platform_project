package com.cloud.analysis.entity;
import com.cloud.analysis.entity.enums.Gender;
import com.cloud.analysis.entity.enums.Role;
import com.cloud.analysis.entity.enums.YesOrNo;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @NotNull
    @Column(name = "user_id")
    private Integer userId;

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

    @Column(name = "phone", length = 11)
    @NotNull
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @NotNull
    private Role role;

    @Column(name = "name", length = 30)
    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_mail_accept")
    @NotNull
    private YesOrNo isMailAccept;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_phone_accept")
    @NotNull
    private YesOrNo isPhoneAccept;

    @Column(name = "age")
    @NotNull
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    @NotNull
    private Gender gender;

    @Column(name = "job", length = 30)
    @NotNull
    private String job;
}
