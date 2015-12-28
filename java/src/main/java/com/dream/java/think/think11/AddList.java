package com.dream.java.think.think11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 添加一组元素.
 *
 * @author 李君波
 * @version v1.0.0
 * @date 2015-11-18
 */
public class AddList {

    public static void main(String[] args){

        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Integer[] moreInts = {6,7,8,9,10};
        collection.addAll(Arrays.asList(moreInts));

        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);

        for (Integer in : collection) {
            System.out.print(in + ",");
        }

        // Arrays.asList();底层表示数组，不能调整尺寸
        List<Integer> list = Arrays.asList(16,17,18,19,20);
        list.set(1, 99);// 可以修改元素
        //list.add(21);//Exception in thread "main" java.lang.UnsupportedOperationException


    }


}
