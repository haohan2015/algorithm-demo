package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @Description: 杨辉三角
 * @date 2019/11/14 18:19
 *
 * 示例:

输入: 5
输出:
[
[1],
[1,1],
[1,2,1],
[1,3,3,1],
[1,4,6,4,1]
]
 *
 */
public class Pascaltriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(numRows == 0){
            return lists;
        }
        if(numRows == 1){
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            lists.add(list);
            return lists;
        }

        lists = generate(numRows - 1);
        List<Integer> lastList = lists.get(lists.size() - 1);
        List<Integer> newList = new ArrayList<Integer>(lastList.size() + 1);
        for (int i = 0; i < lastList.size(); i++) {
            if(i == 0){
                newList.add(lastList.get(i));
            }else{
                newList.add(lastList.get(i) + lastList.get(i-1));
            }
        }
        newList.add(1);
        lists.add(newList);
        return lists;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + generate(5) + "]");
    }

}
