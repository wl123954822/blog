package com.wl.blog.controller;

import com.wl.blog.entity.file.ImageFile;
import com.wl.blog.service.FileImageService;
import com.wl.blog.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传
 */
@RequestMapping("/upload")
@RestController
public class FileUploadController {

    @Autowired
    private FileImageService fileImageService;

    @RequestMapping("/uploadImg")
    public Map<String, Object> fileUpload(@RequestParam("file") MultipartFile file) {
        ImageFile returnimageFile = null;
        Map<String, Object> map = new HashMap<>();
        String imagePath = "E://nginx//";
        String fileLocation = "/images/blogImg/";
        String path = imagePath + fileLocation;
        if (file.getSize() == 0) {
            map.put("status", "error");
            map.put("test", "文件为空");
            return map;
        } else {
            //上传文件名字
            String fileName = file.getOriginalFilename();
            //存储数据库path
            String dbPath = fileName.substring(fileName.lastIndexOf("."));
            try {
                ImageFile f = new ImageFile(file.getOriginalFilename(), file.getContentType(), file.getSize(), file.getBytes());
                f.setMd5(MD5Util.getMD5(file.getInputStream()));
                f.setPath(fileLocation + file.getOriginalFilename());
                f.setContent(null);
                //将信息存到数据库
                returnimageFile = fileImageService.saveImage(f);
                file.transferTo(new File(path + file.getOriginalFilename()));
                map.put("status", "success");
                map.put("imagePath", fileLocation + file.getOriginalFilename());
                map.put("imageId", returnimageFile.getFileId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return map;
        }

    }

}
