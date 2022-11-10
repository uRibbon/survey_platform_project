package com.cloud.analysis.client;

import com.cloud.analysis.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "common-service", configuration = Config.class)
public interface UserServiceClient {
    @GetMapping(value = "/v1/common/user/{userId}")
    UserDTO getUser(@PathVariable String userId);

    @PostMapping(value = "/v1/common/user")
    void insertUser(UserDTO userDTO);
}
