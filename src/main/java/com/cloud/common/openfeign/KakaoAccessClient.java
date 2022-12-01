package com.cloud.common.openfeign;


import feign.Response;
import org.json.simple.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;



@FeignClient(value = "https://iam.kakaoi.io/identity/v3/auth/tokens")
public interface KakaoAccessClient {
    @PostMapping(produces = "application/json")
    Response getAccessToken(@RequestBody JSONObject jsonObject);
}
