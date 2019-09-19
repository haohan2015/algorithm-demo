package com.algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author admin
 * @Description: 二进制求和
 * @date 2019/9/17 21:35
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-binary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class BinarySum {

    public static String addBinary(String a, String b) {

        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carryBit = 0;
        LinkedList<String> list = new LinkedList();
        while (true){
            int valueA = 0;
            if(indexA >= 0){
                valueA = Integer.valueOf(a.substring(indexA,indexA +1));
                indexA--;
            }
            int valueB = 0;
            if(indexB >= 0){
                valueB = Integer.valueOf(b.substring(indexB,indexB +1));
                indexB--;
            }
            int value = valueA + valueB + carryBit;
            if(value % 2 == 0){
                list.addFirst("0");
            }else{
                list.addFirst("1");
            }

            if(value >= 2){
                carryBit = 1;
            }else{
                carryBit = 0;
            }

            if(indexA < 0 && indexB < 0 && carryBit == 0){
                break;
            }
        }
        return list.toString().replace(",","").replace("[","").replace("]","").replace(" ","");
    }

    public static void main(String[] args) {
        System.out.println("args = [" + addBinary("11","1") + "]");
    }

}
