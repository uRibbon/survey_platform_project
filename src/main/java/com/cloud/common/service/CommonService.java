package com.cloud.common.service;

import com.cloud.common.dto.MenuDTO;
import com.cloud.common.entity.*;

import java.util.ArrayList;
import java.util.List;

public interface CommonService {
    List<MenuDTO> getUserMenuDTOList();
    List<MenuDTO> getAdminMenuDTOList();
    List<MenuDTO> getAllMenuDTOList();

    default MenuDTO entityToDTO(Menu menu) {
        MenuDTO dto = MenuDTO.builder()
                .menuId(menu.getMenuId())
                .menuName(menu.getMenuName())
                .menuUrl(menu.getMenuUrl())
                .menuIcon(menu.getMenuIcon())
                .menuList(new ArrayList<>())
                .build();
        return dto;
    }

    List<QuestionType> getQuestionTypeList();
    List<SurveyState> getSurveyStateList();
    List<UserAge> getUserAgeList();
    List<UserJob> getUserJobList();
}
