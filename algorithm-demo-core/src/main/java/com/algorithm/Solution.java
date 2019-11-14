package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @Description: 罗马数字转整数
 * @date 2019/8/15 18:12
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/roman-to-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static int romanToInt(String s) {
        Map<String,Integer> romanMap = new HashMap<String,Integer>(16);
        romanMap.put("I",1);
        romanMap.put("a",4);
        romanMap.put("V",5);
        romanMap.put("b",9);
        romanMap.put("X",10);
        romanMap.put("c",40);
        romanMap.put("L",50);
        romanMap.put("d",90);
        romanMap.put("C",100);
        romanMap.put("e",400);
        romanMap.put("D",500);
        romanMap.put("f",900);
        romanMap.put("M",1000);
        s = s.replace("IV","a")
                .replace("IX","b")
                .replace("XL","c")
                .replace("XC","d")
                .replace("CD","e")
                .replace("CM","f");

        int num = 0;
        char[] nums = s.toCharArray();
        for (int i = 0; i < nums.length; i++) {
            num += romanMap.get(String.valueOf(nums[i]));
        }
        return num;
    }

    public static int romanToInt1(String s) {
        Map<String,Integer> romanMap = new HashMap<String,Integer>(16);
        romanMap.put("I",1);
        romanMap.put("V",5);
        romanMap.put("X",10);
        romanMap.put("L",50);
        romanMap.put("C",100);
        romanMap.put("D",500);
        romanMap.put("M",1000);

        String[] strings = new String[] {"IV", "IX", "XL", "XC", "CD", "CM"};

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num += romanMap.get(String.valueOf(s.charAt(i)));
        }
        for (String roman:strings) {
            if(s.contains(roman)){
                num -=  2 * romanMap.get(roman.substring(0,1));
            }
        }
        return num;
    }

    public static int romanToInt2(String s) {
        Map<String,Integer> romanMap = new HashMap<String,Integer>(16);
        romanMap.put("I",1);
        romanMap.put("V",5);
        romanMap.put("X",10);
        romanMap.put("L",50);
        romanMap.put("C",100);
        romanMap.put("D",500);
        romanMap.put("M",1000);


        int num = 0;
        int rLast = 0;
        for (int i = s.length() -1; i >= 0; i--) {
            int currentNum = romanMap.get(String.valueOf(s.charAt(i)));
            if(currentNum < rLast){
                num -= currentNum;
            }else{
                num += currentNum;
            }
            rLast = currentNum;
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println("result=" +romanToInt2("MCMXCIV"));
    }

}
