package com.cloud.point.openfeign;

import com.cloud.point.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AuthServiceClientTest {
    @Autowired
    AuthServiceClient authServiceClient;

    @Test
    void test() {
        UserDTO userDTO = authServiceClient.getUserDetailInfo("yuri");
        System.out.println("userDTO = " + userDTO);
    }

}