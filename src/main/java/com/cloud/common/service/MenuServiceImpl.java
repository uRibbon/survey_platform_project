package com.cloud.common.service;

import com.cloud.common.dto.MenuDTO;
import com.cloud.common.entity.Menu;
import com.cloud.common.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{
    @Autowired
    private final MenuRepository menuRepository;

    @Override
    public List<MenuDTO> getUserMenuDTOList() {
        List<MenuDTO> menuDTOList = new ArrayList<>();
        List<Menu> largeCategoryList = menuRepository.findLargeUserCategoryList();
        largeCategoryList.forEach(largeCategory -> {
            MenuDTO largeCategoryDTO = entityToDTO(largeCategory);
            List<Menu> middleCategoryList = menuRepository.findMiddleUserCategoryList(largeCategory.getMenuId());
            middleCategoryList.forEach(middleCategory -> {
                MenuDTO middleCategoryDTO = entityToDTO(middleCategory);
                largeCategoryDTO.addMenuList(middleCategoryDTO);
                List<Menu> smallCategoryList = menuRepository.findSmallUserCategoryList(middleCategory.getMenuId());
                smallCategoryList.forEach(smallCategory -> {
                    MenuDTO smallCategoryDTO = entityToDTO(smallCategory);
                   middleCategoryDTO.addMenuList(smallCategoryDTO);
                });
            });
            menuDTOList.add(largeCategoryDTO);
        });
        return menuDTOList;
    }

    @Override
    public List<MenuDTO> getAdminMenuDTOList() {
        List<MenuDTO> menuDTOList = new ArrayList<>();
        List<Menu> largeCategoryList = menuRepository.findLargeAdminCategoryList();
        largeCategoryList.forEach(largeCategory -> {
            MenuDTO largeCategoryDTO = entityToDTO(largeCategory);
            List<Menu> middleCategoryList = menuRepository.findMiddleAdminCategoryList(largeCategory.getMenuId());
            middleCategoryList.forEach(middleCategory -> {
                MenuDTO middleCategoryDTO = entityToDTO(middleCategory);
                largeCategoryDTO.addMenuList(middleCategoryDTO);
                List<Menu> smallCategoryList = menuRepository.findSmallAdminCategoryList(middleCategory.getMenuId());
                smallCategoryList.forEach(smallCategory -> {
                    MenuDTO smallCategoryDTO = entityToDTO(smallCategory);
                    middleCategoryDTO.addMenuList(smallCategoryDTO);
                });
            });
            menuDTOList.add(largeCategoryDTO);
        });
        return menuDTOList;
    }

    @Override
    public List<MenuDTO> getAllMenuDTOList() {
        List<MenuDTO> menuDTOList = new ArrayList<>();
        List<Menu> largeCategoryList = menuRepository.findLargeAllCategoryList();
        largeCategoryList.forEach(largeCategory -> {
            MenuDTO largeCategoryDTO = entityToDTO(largeCategory);
            List<Menu> middleCategoryList = menuRepository.findMiddleAllCategoryList(largeCategory.getMenuId());
            middleCategoryList.forEach(middleCategory -> {
                MenuDTO middleCategoryDTO = entityToDTO(middleCategory);
                largeCategoryDTO.addMenuList(middleCategoryDTO);
                List<Menu> smallCategoryList = menuRepository.findSmallAllCategoryList(middleCategory.getMenuId());
                smallCategoryList.forEach(smallCategory -> {
                    MenuDTO smallCategoryDTO = entityToDTO(smallCategory);
                    middleCategoryDTO.addMenuList(smallCategoryDTO);
                });
            });
            menuDTOList.add(largeCategoryDTO);
        });
        return menuDTOList;
    }
}
