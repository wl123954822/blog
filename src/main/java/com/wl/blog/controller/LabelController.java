package com.wl.blog.controller;

import com.wl.blog.Dto.LaberDto;
import com.wl.blog.entity.Label;
import com.wl.blog.service.LaberService;
import com.wl.blog.util.RegExpUtil;
import com.wl.blog.util.StringRandom;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        List<String> newArr = new ArrayList();
        for (Label label : labels){
            //把名称取出来，放入新List中
            newArr.add(label.getLabelName());
        }
        //用set去重
        Set set = new HashSet(newArr);
        //把set转为字符串
        String strQueueNumList = StringUtils.join(set);
        String newlaberName=strQueueNumList.replaceAll("，",",");
        String[] liberNlis=newlaberName.split(",");

        map.put("list",liberNlis);
        return map;
    }


    @RequestMapping("/laberSet/{id}")
    public Map<String,Object> labelSet(){
        Map<String,Object> map=new HashMap<String, Object>();
        List<LaberDto> labels=laberService.laberSet();
        for (LaberDto laberDto : labels){
            System.out.println(laberDto.getLabelName());
            Set set = new HashSet(labels);
        }
       /* //把set转为字符串
        String strQueueNumList = StringUtils.join(set);
        String newlaberName=strQueueNumList.replaceAll("，",",");
        String[] liberNlis=newlaberName.split(",");
        List<String> lis = new ArrayList<>();
       */

        map.put("list","A");
        return map;
    }


}
