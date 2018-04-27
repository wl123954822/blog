package com.wl.blog.service.impl;

import com.wl.blog.Dto.ClassificationDto;
import com.wl.blog.dao.ClassificationDao;
import com.wl.blog.entity.Classification;
import com.wl.blog.service.ClassificationService;
import com.wl.blog.util.Interface.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/10-10:06
 */
@Service
public class ClassificationServiceImpl implements ClassificationService {

    @Autowired
    private ClassificationDao classificationDao;

    @Override
    public boolean insertClassification(Classification classification) {
        return classificationDao.insertInto(classification);
    }

    @Override
    public List<Classification> classifList() {
        return classificationDao.classifList();
    }

    @Override
    public Classification classByname(String classificationName) {
        return classificationDao.byclassifName(classificationName);
    }

    @Override
    public boolean deleteClassif(int classificationId) {
        return classificationDao.deleteClassif(classificationId);
    }

    @Override
    public boolean updateClassifStatu(int classificationId, int classificationIdStatus) {
        return classificationDao.updateClassifStatus(classificationId, classificationIdStatus);
    }

    @Override
    public List<Classification> classifListByStatus(int classificationIdStatus) {
        return classificationDao.classifListByStatus(classificationIdStatus);
    }

    @Override
    public List<ClassificationDto> getNameId() {

        List<ClassificationDto> list = classificationDao.getClassificat();
        for (ClassificationDto classificationDto : list) {
            int classId = classificationDto.getClassificationId();
            System.out.println(classId);
            int result = classificationDao.getCount(classId);
            classificationDto.setCount(result);
        }
        return list;
    }
}
