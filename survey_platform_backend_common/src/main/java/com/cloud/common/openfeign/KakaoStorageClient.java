package com.cloud.common.openfeign;


import feign.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

@FeignClient(value = "https://objectstorage.kr-central-1.kakaoi.io/v1")
public interface KakaoStorageClient {
    @PutMapping(value = "/{account}/{bucket_name}/{path}/{file}", consumes = "image/jpeg")
    Response fileUpload(
            @RequestHeader("X-Auth-Token") String authToken,
            @PathVariable("account") String account,
            @PathVariable("bucket_name") String bucketName,
            @PathVariable("path") String path,
            @PathVariable("file") String file,
            @RequestBody byte[] bytes);

    @GetMapping(value = "/{account}/{bucket_name}/{path}")
    Response fileDownload(
            @RequestHeader("X-Auth-Token") String authToken,
            @PathVariable("account") String account,
            @PathVariable("bucket_name") String bucketName,
            @PathVariable("path") String path);

}
