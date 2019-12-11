package com.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author admin
 * @Description: 回文全排列
 * @date 2019/12/11 20:14
 *
 * 题目给了我们一个string s，让我们判断它是不是可以变作回文。
 * Example 1:

Input: "code"
Output: false
Example 2:

Input: "aab"
Output: true
Example 3:

Input: "carerac"
Output: true
 */
public class PalindromePermutation {

    public static boolean canPermutePalindrome(String str){
        if(str == null || str.length() == 0){
            return true;
        }

        Map<String,Integer> integerMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int count = integerMap.getOrDefault(str.substring(i,i+1),0);
            count++;
            integerMap.put(str.substring(i,i+1),count);
        }

        Iterator<String> iterator = integerMap.keySet().iterator();
        int num = 0;
        while (iterator.hasNext()){
            if(integerMap.get(iterator.next()) % 2 == 1){
                num++;
            }
        }

        return ((str.length() % 2 == 0) && num == 0) || (str.length() % 2 == 1) && num == 1;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + canPermutePalindrome("aab") + "]");
    }
}
