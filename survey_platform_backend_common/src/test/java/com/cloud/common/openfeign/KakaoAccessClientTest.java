//package com.cloud.common.openfeign;
//
//import feign.Response;
//
//import org.apache.kafka.common.requests.ResponseHeader;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class KakaoAccessClientTest {
//    @Autowired
//    KakaoAccessClient kakaoAccessClient;
//
//    @Test
//    void getToken() {
//        JSONObject application_credential = new JSONObject();
//        application_credential.put("id","cffe7bbbeacc46cf910fcc5baa9caf16");
//        application_credential.put("secret", "vZdtSm7ZOAFxsXeDyP-DWMjgyOvT3TBXbgxT2uKEu_F3TzYcZwnUykfkfpc6VSmI44ndlQOYMIYWu98AxHD9iQ");
//        JSONArray methods = new JSONArray();
//        methods.add("application_credential");
//        JSONObject identity = new JSONObject();
//        identity.put("methods",methods);
//        identity.put("application_credential",application_credential);
//        JSONObject auth = new JSONObject();
//        auth.put("identity",identity);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("auth", auth);
//        Response accessToken = kakaoAccessClient.getAccessToken(jsonObject);
//        System.out.println("accessToken = " + accessToken.headers().get("x-subject-token").toArray()[0]);
//    }
//
//}
