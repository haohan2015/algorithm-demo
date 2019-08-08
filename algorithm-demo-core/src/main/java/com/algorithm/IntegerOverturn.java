package com.algorithm;

/**
 * @author admin
 * @Description: TODO
 * @date 2019/8/7 18:56
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerOverturn {

    public static int reverse(int x) {
        String str = String.valueOf(x);
        char[] charArray = str.toCharArray();
        char[] newCharArray = new char[str.length()];
        for (int i = 0; i < charArray.length; i++) {
            newCharArray[charArray.length - i -1] = charArray[i];
        }

        str = String.copyValueOf(newCharArray).trim();
        if(str.endsWith("-")){
            str = "-" + str.substring(0,str.length() -1);
        }
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int reverse1(int x) {
        //234561
        //165432
        String str = String.valueOf(x);
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            stringBuilder.append(charArray[length - i - 1]);
        }
        try {
            if(charArray[0] == '-'){
                stringBuilder.deleteCharAt(length - 1);
                return Integer.valueOf(stringBuilder.toString()) * -1;
            }
            return Integer.valueOf(stringBuilder.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
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
        System.out.println("args = [" + reverse2(1534236469) + "]");
    }

}
