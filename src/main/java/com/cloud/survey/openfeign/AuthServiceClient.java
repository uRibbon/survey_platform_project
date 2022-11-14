package com.cloud.survey.openfeign;

import com.cloud.survey.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "auth-client", url="localhost:9000/auth-service/v1/user", configuration = FeignConfig.class)
public interface AuthServiceClient {
    @GetMapping(value = "/detail?user_id={UserId}")
    UserDTO getUserDetailInfo(@PathVariable String UserId);
}
