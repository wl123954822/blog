package com.wl.blog.service;

import com.wl.blog.Dto.ClassificationDto;
import com.wl.blog.entity.Classification;

import java.util.List;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/10-10:04
 */
public interface ClassificationService {

    boolean insertClassification(Classification classification);

    List<Classification> classifList();

    Classification classByname(String classificationName);

    boolean deleteClassif(int classificationId);

    boolean updateClassifStatu(int classificationId, int classificationIdStatus);

    List<Classification> classifListByStatus(int classificationIdStatus);

    List<ClassificationDto> getNameId();
}
