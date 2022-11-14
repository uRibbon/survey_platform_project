package com.cloud.common.openfeign;

import com.cloud.common.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "auth-service", configuration = FeignConfig.class)
public interface AuthServiceClient {
    @GetMapping(value = "/v1/user/detail")
    ResponseEntity<UserDTO> getUserDetail(@RequestParam(value = "user_id") String UserId);
}
