package com.cloud.common.controller;

import com.cloud.common.dto.FileDTO;
import com.cloud.common.openfeign.KakaoAccessClient;
import com.cloud.common.openfeign.KakaoStorageClient;
import feign.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.engine.jdbc.StreamUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Log4j2
@RestController
@RequestMapping(value="v1/common/file")
@RequiredArgsConstructor
public class FileController {
    private final KakaoStorageClient kakaoStorageClient;
    private final KakaoAccessClient kakaoAccessClient;

    @Value("${kakao.access.id}")
    String accessId;

    @Value("${kakao.access.secret}")
    String accessSecret;

    @Value("${kakao.storage.account}")
    String account;

    @Value("${kakao.storage.bucketName}")
    String bucketName;

    @PostMapping("/upload/{folder}")
    public FileDTO uploadFile(
            @RequestParam MultipartFile multipartFile,
            @PathVariable String folder) throws IllegalStateException, IOException {

        // 파일 이름 생성하기 (uuid.확장자)
        String originalName = multipartFile.getOriginalFilename();
        String fileUuid = UUID.randomUUID().toString();
        String fileExt = originalName.substring(originalName.lastIndexOf("."));
        String fileName = fileUuid + fileExt;

        // 파일 업로드
        Response response = kakaoStorageClient.fileUpload(getAuthToken(), account, bucketName, folder, fileName, multipartFile.getBytes());
        if (response.status() == 201 ) {
            FileDTO fileDTO = FileDTO.builder()
                    .orgName(originalName)
                    .fileName(folder + File.separator + fileName)
                    .contentType(multipartFile.getContentType())
                    .fileSize(Long.valueOf(multipartFile.getSize()).intValue())
                    .build();
            return fileDTO;
        }
        return null;
    }

    @PostMapping("/download")
    public BufferedImage downloadFile(@RequestBody FileDTO fileDTO) {
        // 파일 다운로드
        Response response = kakaoStorageClient.fileDownload(getAuthToken(), account, bucketName, fileDTO.getFileName());
        if (response.status() == 200) {
            try {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                StreamUtils.copy(response.body().asInputStream(), outputStream);
                ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
                return ImageIO.read(inputStream);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return null;
    }

    public String getAuthToken() {
        JSONObject application_credential = new JSONObject();
        application_credential.put("id", accessId);
        application_credential.put("secret", accessSecret);
        JSONArray methods = new JSONArray();
        methods.add("application_credential");
        JSONObject identity = new JSONObject();
        identity.put("methods", methods);
        identity.put("application_credential", application_credential);
        JSONObject auth = new JSONObject();
        auth.put("identity", identity);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("auth", auth);
        Response accessToken = kakaoAccessClient.getAccessToken(jsonObject);
        return accessToken.headers().get("x-subject-token").toString();
    }



}
