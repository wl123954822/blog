package com.wl.blog.service;

import com.wl.blog.entity.file.ImageFile;

import java.util.List;

public interface FileImageService {
    /**
     * 保存文件
     */
    ImageFile saveImage(ImageFile imageFile);

    /**
     * 删除文件
     */
    Boolean removeImage(int id);

    /**
     * 根据Id获取文件
     */
    ImageFile getFileById(int id);

    /**
     * 获取文件列表
     */
    List<ImageFile> listImages();
}
