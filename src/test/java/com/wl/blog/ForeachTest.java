package com.wl.blog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: wl
 * @Description:
 * @Date:Create in 2017/11/30-9:51
 */
public class ForeachTest {

    public static void main(String[] args){

        int[] arr={1,2,3,4,5};
        /**
         * 旧式遍历
         */
        for(int i=0; i<arr.length;i++){
           System.out.println("旧式遍历"+arr[i]);
        }

        /**
         * 新式遍历
         */
        for (int element: arr) {
            System.out.println("新式遍历"+element);
        }


        /************************遍历二维数组***************************/
                int[][] arr2={{1,2,3},{4,5,6},{7,8,9}};
        /**
         * 旧式遍历
         */
        for (int j = 0; j < arr2.length; j++) {
            for (int z = 0; z < arr2[j].length; z++) {
                System.out.println(arr2[j][z]);
            }
        }
        /**
         * 新式遍历
         */
        for (int[] row : arr2) {
            for (int element : row) {
                System.out.println(element);
            }
        }

        /***************************遍历list*******************************/
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        /**
         * 普通for循环遍历
         */
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        /**
         * 迭代器遍历
         */
        for (Iterator<String> iter=list.iterator(); iter.hasNext();){
            System.out.println(iter.next());
        }
        /**
         * 增强for
         */
        for (String str:list) {
            System.out.println(str);
        }
    }
}
