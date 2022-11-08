package com.cloud.common.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MenuDTO {
    private Integer menuId;
    private String menuName;
    private String menuUrl;
    private String icon;
    private List<MenuDTO> menuList;

    public void addMenuDTOList(MenuDTO menuDTO) {
        menuList.add(menuDTO);
    }
}
