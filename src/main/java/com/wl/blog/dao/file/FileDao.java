package com.wl.blog.dao.file;

import com.wl.blog.entity.file.ImageFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface FileDao {

    /**
     * 保存文件
     */
    Boolean saveImage(ImageFile imageFile);

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
