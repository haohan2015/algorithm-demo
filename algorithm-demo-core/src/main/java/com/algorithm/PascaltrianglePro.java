package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @Description: 杨辉三角升级
 * @date 2019/11/14 18:55
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 示例:

输入: 3
输出: [1,3,3,1]
进阶：

你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class PascaltrianglePro {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list;
        if(rowIndex == 0){
            list = new ArrayList<Integer>();
            list.add(1);
            return list;
        }

        list = new ArrayList<Integer>(rowIndex + 1);
        getRow1(rowIndex,list);
        return list;
    }

    public static void getRow1(int rowIndex,List<Integer> list){
        if(rowIndex == 0){
            list.add(1);
        }else{
            getRow1(rowIndex - 1,list);
            for (int i = list.size()-1; i >= 0; i--) {
                if(i != 0){
                    list.set(i,(list.get(i) + list.get(i-1)));
                }else{
                    list.set(i,1);
                }
            }
            list.add(1);

        }
    }

    public static void main(String[] args) {
        System.out.println("args = [" + getRow(3) + "]");
    }

}
