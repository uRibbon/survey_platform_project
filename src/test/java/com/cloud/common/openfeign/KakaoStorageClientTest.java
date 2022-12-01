//package com.cloud.common.openfeign;
//
//import feign.Response;
//import org.hibernate.engine.jdbc.StreamUtils;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.imageio.IIOImage;
//import javax.imageio.ImageIO;
//import javax.imageio.ImageWriter;
//import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
//import javax.imageio.stream.ImageOutputStream;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.util.Iterator;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class KakaoStorageClientTest {
//    @Autowired
//    KakaoStorageClient kakaoStorageClient;
//
//    @Autowired
//    KakaoAccessClient kakaoAccessClient;
//
//    @Value("${kakao.access.id}")
//    String accessId;
//
//    @Value("${kakao.access.secret}")
//    String accessSecret;
//
//    @Value("${kakao.storage.account}")
//    String account;
//
//    @Value("${kakao.storage.bucketName}")
//    String bucketName;
//
//    @Test
//    void download() {
//        Response response = kakaoStorageClient.fileDownload(getAuthToken(), account, bucketName, "user/7452fab1-621b-4840-98c2-bc121e3d74a9.jpg");
//        System.out.println("response = " + response);
//        System.out.println("response.body() = " + response.body());
//
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//        try {
//            StreamUtils.copy(response.body().asInputStream(), output);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("output = " + output.getClass().getName());
//
//        ByteArrayInputStream ba = new ByteArrayInputStream(output.toByteArray());
//        try {
//            BufferedImage bufferedImage = ImageIO.read(ba);
//            File outputfile = new File("image.jpg");
//            ImageIO.write(bufferedImage, "jpg", outputfile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//
//    }
//
//    public String getAuthToken() {
//        JSONObject application_credential = new JSONObject();
//        application_credential.put("id", accessId);
//        application_credential.put("secret", accessSecret);
//        JSONArray methods = new JSONArray();
//        methods.add("application_credential");
//        JSONObject identity = new JSONObject();
//        identity.put("methods", methods);
//        identity.put("application_credential", application_credential);
//        JSONObject auth = new JSONObject();
//        auth.put("identity", identity);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("auth", auth);
//        Response accessToken = kakaoAccessClient.getAccessToken(jsonObject);
//        return accessToken.headers().get("x-subject-token").toString();
//    }
//
//}
