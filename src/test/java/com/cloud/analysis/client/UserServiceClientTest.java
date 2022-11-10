package com.cloud.analysis.client;

import com.cloud.analysis.dto.UserDTO;
import com.cloud.analysis.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceClientTest {
    @Autowired
    UserServiceClient userServiceClient;

    @Test
    void readUser() {
        UserDTO userDTO = userServiceClient.getUser("yena1");
        System.out.println("userDTO = " + userDTO);
    }

    @Test
    void insertUser() {
        UserDTO userDTO = UserDTO.builder()
                .userId("yena121")
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
        userServiceClient.insertUser(userDTO);
    }
}
