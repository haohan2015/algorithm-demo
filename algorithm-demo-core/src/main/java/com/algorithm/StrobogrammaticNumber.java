package com.algorithm;

/**
 * @author admin
 * @Description: 对称数
 * @date 2019/12/5 21:05
 * Example 1:

Input:  "69"
Output: true
Example 2:

Input:  "88"
Output: true
Example 3:

Input:  "962"
Output: false


这道题定义了一种对称数，就是说一个数字旋转180度和原来一样，也就是倒过来看一样，比如609，倒过来还是609等等
 0 1 6 8 9
 */
public class StrobogrammaticNumber {

    public static boolean isStrobogrammatic(String num){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            String s1 = overturnNum(num.substring(num.length() - i -1,num.length() -i));
            if(s1.equals("-1")){
                return false;
            }

            stringBuilder.append(s1);
        }

        return num.equals(stringBuilder.toString());
    }

    public static String overturnNum(String num){
        switch (num){
            case "6": return "9";
            case "9": return "6";
            case "1": return "1";
            case "0": return "0";
            case "8": return "8";
            default: return "-1";
        }
    }

    public static void main(String[] args) {
        System.out.println("args = [" + isStrobogrammatic("962") + "]");
    }
}
