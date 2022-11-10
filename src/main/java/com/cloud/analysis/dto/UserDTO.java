package com.cloud.analysis.dto;
import com.cloud.analysis.entity.Role;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserDTO {
    private String userId;
    private String userPwd;
    private String name;
    private String job;
    private Integer age;
    private Boolean gender;
    private String phone;
    private String mailAddr;
    private Boolean isMailAccept;
    private Boolean isPhoneAccept;
    private Role role;
    private String regId;
    private LocalDateTime regDt;
    private Boolean useYn;
}
