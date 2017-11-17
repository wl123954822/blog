package com.wl.blog.controller;

import com.wl.blog.entity.Classification;
import com.wl.blog.service.ClassificationService;
import com.wl.blog.util.RegExpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Documented;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/10-10:08
 */
@RestController
@RequestMapping("/classific")
public class ClassificationController {

    @Autowired
    private ClassificationService classificationService;

    @RequestMapping("/add")
    public Map<String,Object> addClassific(Classification classification){
        Map<String, Object> map = new HashMap<String, Object>();
        Classification classifications = classificationService.classByname(classification.getClassificationName());

        if (!RegExpUtil.isNull(classification.getClassificationName())) {
                if (classifications!=null) {
                    map.put("status", "error");
                    map.put("text", "重复");
                } else {
                    if (classificationService.insertClassification(classification)) {
                        map.put("status", "success");
                        map.put("text", "添加成功");
                    }
                }
                return map;
        } else {
            map.put("status", "error");
            map.put("text", "传参错误");
        }
        return map;
    }


    @RequestMapping("/list")
    public Map<String,Object> classificationList(){
        Map<String,Object> map=new HashMap<String, Object>();

       List<Classification> classifications= classificationService.classifList();
        map.put("total",10);
       map.put("rows",classifications);
        return map;
    }

    @RequestMapping("/deleteClas")
    public Map<String, Object> deleteClass(@RequestParam("classificationId") int classificationId) {

        Map<String, Object> map = new HashMap<String, Object>();
        if (!RegExpUtil.isNull(classificationId + "")) {
            if (classificationService.deleteClassif(classificationId)) {
                map.put("status", "success");
                map.put("text", "删除成功");
            } else {
                map.put("status", "error");
                map.put("text", "删除失败");
            }
        } else {
            map.put("status", "error");
            map.put("text", "参数错误");
        }
        return map;
    }


    @RequestMapping("/updateClas")
    public Map<String, Object> updateClass(@RequestParam("classificationId") int classificationId, @RequestParam("classificationIdStatus") int classificationIdStatus) {
        Map<String, Object> map = new HashMap<String, Object>();

        if (!RegExpUtil.isNull(classificationId + "") && !RegExpUtil.isNull(classificationIdStatus + "")) {
            if (classificationService.updateClassifStatu(classificationId, classificationIdStatus)) {
                map.put("status", "success");
                map.put("text", "变更成功");
            }
        } else {
            map.put("status", "error");
            map.put("text", "参数错误");
        }
        return map;
    }


    @RequestMapping("/classifSta")
    public Map<String,Object> classList(@RequestParam("classificationIdStatus") int classificationIdStatus){
        Map<String, Object> map = new HashMap<String, Object>();

        List<Classification>  list= classificationService.classifListByStatus(classificationIdStatus);

        map.put("list",list);
        return map;
    }
}
