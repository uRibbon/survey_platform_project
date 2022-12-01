package com.cloud.analysis.client;

//import com.cloud.analysis.dto.User.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "auth-service", configuration = Config.class)
public interface AuthServiceClient {
//    @GetMapping(value = "/v1/common/user/{userId}")
//    UserDTO getUser(@PathVariable String userId);
//
//    @PostMapping(value = "/v1/common/user")
//    void insertUser(UserDTO userDTO);
}


