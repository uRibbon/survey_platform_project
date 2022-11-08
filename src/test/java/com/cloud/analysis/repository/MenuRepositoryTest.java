package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuRepositoryTest {
    @Autowired
    MenuRepository menuRepository;

    @Test
    void read(){
        List <Menu> menuList = menuRepository.findAll();
        menuList.forEach(menu -> {
            System.out.println("menu = " + menu);
        });
    }
}