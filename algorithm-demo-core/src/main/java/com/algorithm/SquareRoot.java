package com.algorithm;

/**
 * @author admin
 * @Description:  x 的平方根
 * @date 2019/9/19 18:41
 *
 * 实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sqrtx
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SquareRoot {

    public static int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        int index = String.valueOf(x).length() % 2 + String.valueOf(x).length() / 2;
        long min = 1;
        long max = 1;
        while (index > 0){
            max *= 10;
            index--;
        }

        if(x >= (max * max)){
            return (int)max;
        }

        while ((max - min) > 1){
            long middle = (min + max) / 2;
            if(middle * middle > x){
                max = middle;
            }else{
                min = middle;
            }
        }

        return (int)min;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + mySqrt(2147395599) + "]");
        System.out.println("args = [" + 100000 * 100000 + "]");
    }

}
