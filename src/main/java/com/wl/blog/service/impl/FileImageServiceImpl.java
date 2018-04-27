package com.wl.blog.service.impl;

import com.wl.blog.dao.file.FileDao;
import com.wl.blog.entity.file.ImageFile;
import com.wl.blog.service.FileImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileImageServiceImpl implements FileImageService {

    @Autowired
    private FileDao fileDao;

    @Override
    public ImageFile saveImage(ImageFile imageFile) {
        if (fileDao.saveImage(imageFile)) {
            System.out.println(imageFile.getFileId());
            return fileDao.getFileById(imageFile.getFileId());
        }
        return new ImageFile();
    }

    @Override
    public Boolean removeImage(int id) {
        return fileDao.removeImage(id);
    }

    @Override
    public ImageFile getFileById(int id) {
        return fileDao.getFileById(id);
    }

    @Override
    public List<ImageFile> listImages() {
        return fileDao.listImages();
    }
}
