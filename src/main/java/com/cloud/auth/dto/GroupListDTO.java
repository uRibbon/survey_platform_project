package com.cloud.auth.dto;


import com.cloud.auth.entity.DelYn;
import com.cloud.auth.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupListDTO {
    private int groupId;
    private String groupName;
    private String groupDescription;
    private Integer groupCnt;
    private User user;
    private LocalDateTime regDt;
    private String modId;
    private LocalDateTime modDt;
    private DelYn delYn;
}
