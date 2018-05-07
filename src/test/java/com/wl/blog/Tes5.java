package com.wl.blog;

import com.wl.blog.entity.Click;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Tes5 {


    public static void main(String args[]){
        Click click = new Click();
        click.setBlogId(1);
        click.setClickNum(1);
        click.setStatusId(1);
        click.setId(1);

        Click click2 = new Click();
        click2.setId(2);
        click2.setStatusId(2);
        click2.setClickNum(2);
        click2.setBlogId(2);
        Map<String,Object> map = new HashMap<>();
          map.put("l1",click);
          map.put("l2",click2);

        /**
         * 单只获取key或者value
         */

        for (String key :map.keySet()){
            System.out.println("key "+key);
        }
        for (Object value : map.values()){
            System.out.println("value "+value);
        }

        /**
         * 同时获取key和value
         */
        for (String key : map.keySet()){
            System.out.println("key "+key+" : " + map.get(key) );
        }

        /**
         * entrySet
         */
        for (Map.Entry<String,Object> entry : map.entrySet()){
            System.out.println("key : " +entry.getKey() + "--" + entry.getValue());
        }


        /**
         * iterator
         */
        Iterator<Map.Entry<String, Object>> iterable =   map.entrySet().iterator();
        while (iterable.hasNext()){
            Map.Entry<String,Object> entry = iterable.next();
            System.out.println(entry.getKey()+":" +entry.getValue());
        }


        /**
         * lambda
         */
        map.forEach((key,value) ->{
            System.out.println(key+":"+value);
        });
    }
}
