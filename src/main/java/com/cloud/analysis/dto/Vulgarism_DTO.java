package com.cloud.analysis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vulgarism_DTO {
    private Integer surId;
    private Boolean infoYn;
    private Boolean questionYn;
}