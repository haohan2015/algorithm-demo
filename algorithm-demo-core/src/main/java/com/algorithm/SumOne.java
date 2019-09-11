package com.algorithm;

import java.util.Arrays;

/**
 * @author admin
 * @Description: 加一
 * @date 2019/9/10 20:18
 *
 *
 *给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumOne {


    public static int[] plusOne(int[] digits) {

        int m = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + m;
            if(sum >= 10){
                m = sum / 10;
                digits[i] = sum % 10;
            }else{
                m = 0;
                digits[i] = sum;
            }
        }

        if(m == 1){
            int[] finalArray = new int[digits.length + 1];
            for (int i = 0; i < finalArray.length; i++) {
                finalArray[i] = m;
                if(i >= digits.length){
                    break;
                }
                m = digits[i];
            }
            return finalArray;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9};
        Arrays.stream(plusOne(digits)).forEach(i-> System.out.println("args = [" + i + "]"));
    }

}
