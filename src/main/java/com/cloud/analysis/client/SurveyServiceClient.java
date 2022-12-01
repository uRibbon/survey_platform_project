package com.cloud.analysis.client;

import com.cloud.analysis.dto.VulgarismDTO;
import com.cloud.analysis.entity.Vulgarism.SurveyVulgarism;
import org.json.simple.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "survey-service",url="localhost:9000/survey-service", configuration = Config.class)
public interface SurveyServiceClient {
    @PostMapping(value = "/v1/survey/vulgarismInsert")
    void vulgarismInsert(@RequestBody VulgarismDTO vulgarismDTO);
}
