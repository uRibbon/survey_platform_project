package com.cloud.auth.dto;


import com.cloud.auth.entity.DelYn;
import com.cloud.auth.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonFormat
public class GroupListDTO {
    private int groupId;

    private String groupName;

    private String groupDescription;

    private Integer groupCnt;

    private User user;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;

    private String modId;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modDt;

    private DelYn delYn;
}
