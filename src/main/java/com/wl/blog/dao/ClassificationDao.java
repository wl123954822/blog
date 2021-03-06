package com.wl.blog.dao;

import com.wl.blog.Dto.ClassificationDto;
import com.wl.blog.entity.Classification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wl
 * @Description:分类Dao
 * @Date:Create in 2017/11/10-9:56
 */
@Mapper
public interface ClassificationDao {
    //新增
    boolean insertInto(Classification classification);

    //显示list
    List<Classification> classifList();

    //通过名称获取
    Classification byclassifName(String classificationName);

    //删除分类
    boolean deleteClassif(int classificationId);

    //更新显示状态
    boolean updateClassifStatus(@Param("classificationId") int classificationId, @Param("classificationIdStatus") int classificationIdStatus);

    List<Classification> classifListByStatus(int classificationIdStatus);


    //首页显示分类

    /**
     * name,和id
     *
     * @return
     */
    List<ClassificationDto> getClassificat();


    //统计个数
    Integer getCount(int classificationId);
}
