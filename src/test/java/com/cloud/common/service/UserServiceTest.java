package com.cloud.common.service;

import com.cloud.common.dto.UserDTO;
import com.cloud.common.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    void insertUser() {
        UserDTO userDTO = UserDTO.builder()
                .userId("yena11")
                .userPwd("djfsldfjlksdjf")
                .name("yena")
                .job("student")
                .age(25)
                .gender(true)
                .phone("01012345678")
                .mailAddr("yena@gachon.ac.kr")
                .isMailAccept(true)
                .isPhoneAccept(true)
                .role(Role.MEMBER)
                .regId("yena")
                .regDt(LocalDateTime.now())
                .useYn(true)
                .build();
        userService.insertUser(userDTO);
    }
}
