package com.wl.blog;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/30-10:18
 */
public class ForeachTest2 {

    public static void main(String args[]){
       //定义一个数组
        int arr[]=new int[4];
        for (int x:arr){
            System.out.println(x);
        }
        //通过索引给数组元素赋值

        for (int i=3;i>0;i--){
            arr[i]=i;
        }


    }
}
