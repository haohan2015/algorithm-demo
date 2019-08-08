package com.algorithm;

/**
 * @author admin
 * @Description: TODO
 * @date 2019/8/8 18:10
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Palindrome {

    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            if(charArray[i] != charArray[charArray.length - i -1]){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome1(int x) {
        if(x < 0){
            return false;
        }
        int div = 1;
        while ((x / div) >= 10) div = div * 10;
        while (x > 0){
            int left = x / div;
            int right = x % 10;
            if(left != right){
                return false;
            }
            x = (x % div) / 10;
            div = div /100;
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if(x < 0 || ((x % 10) == 0 && x != 0)){
            return false;
        }
        int y = 0;
        while (x > y){
            y = y * 10 + x % 10;
            x /= 10;
        }

        return x == y || (y / 10) == x;
    }

    public static boolean isPalindrome3(int x) {
        if(x < 0 || ((x % 10) == 0 && x != 0)){
            return false;
        }

        return x == reverse2(x);
    }

    public static int reverse2(int x) {
        long res = 0;
        while (x != 0){
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)?0: (int) res;
    }


    public static void main(String[] args) {
        System.out.println("args = [" + isPalindrome3(1001) + "]");
    }
}
