package com.cloud.analysis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VulgarismDTO {
    private Integer surId;
    private Boolean infoYn;
    private Boolean questionYn;
}