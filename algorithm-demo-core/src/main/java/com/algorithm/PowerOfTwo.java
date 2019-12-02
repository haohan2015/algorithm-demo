package com.algorithm;

/**
 * @author admin
 * @Description: 2的幂
 * @date 2019/12/2 19:14
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

示例 1:

输入: 1
输出: true
解释: 20 = 1
示例 2:

输入: 16
输出: true
解释: 24 = 16
示例 3:

输入: 218
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/power-of-two
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        if(0 == n || n < 0){
            return false;
        }
        String binaryStr = Integer.toBinaryString(n);
        return binaryStr.indexOf("1") == binaryStr.lastIndexOf("1")?true:false;
    }

    public static boolean isPowerOfTwo1(int n) {
        if(0 == n || n < 0){
            return false;
        }
        while (n > 1){
            if((n % 2) != 0){
                return false;
            }
            n /= 2;
        }

        return n == 1?true:false;
    }


    public static void main(String[] args) {
        System.out.println("args = [" + isPowerOfTwo1(126) + "]");
    }
}
