package com.cloud.auth.dto;


import com.cloud.auth.entity.DelYn;
import com.cloud.auth.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@JsonFormat
public class GroupDetailDTO {
    private Integer groupId;

    private String groupName;

    private String groupDescription;

    private Integer groupCnt;

//    private List<User> userList; // 그룹 개설자 정보
//    public void addUserList(User user) {
//        userList.add(user);
//    }

    private User user;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")

    private LocalDateTime regDt;

    private String modId;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")

    private LocalDateTime modDt;

    private DelYn delYn;

}
