package com.cloud.point.openfeign;

import com.cloud.point.dto.UserDTO;
import org.apache.kafka.clients.admin.Config;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "auth-service", configuration = Config.class)
public interface AuthServiceClient {

    @GetMapping(value = "/v1/user/detail")
    UserDTO getUserDetailInfo(@RequestParam(value = "user_id") String UserId);
}