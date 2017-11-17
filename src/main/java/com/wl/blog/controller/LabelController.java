package com.wl.blog.controller;

import com.wl.blog.entity.Label;
import com.wl.blog.service.LaberService;
import com.wl.blog.util.RegExpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/13-16:43
 */
@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LaberService laberService;

    @RequestMapping("/add")
    public Map<String,Object> addLabel(Label label){
        Map<String,Object> map=new  HashMap<String, Object>();
        Label label1=laberService.lablByName(label.getLabelName());
        if (!RegExpUtil.isNull(label.getLabelName())){
            if (label1!=null){
                map.put("status","error");
                map.put("text","重复");
            }else {
                if (laberService.insertLaber(label)) {
                    map.put("status", "success");
                    map.put("text", "添加成功");
                } else {
                    map.put("status", "error");
                    map.put("text", "添加失败");
                }
            }
        }else {
            map.put("status","error");
            map.put("text","参数错误");
        }
        return map;
    }


    @RequestMapping("/list")
    public Map<String,Object> labelList(){
        Map<String,Object> map=new HashMap<String, Object>();
        List<Label> labels=laberService.labelList();
        map.put("list",labels);
        return map;
    }

}
