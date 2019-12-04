package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @Description: 有效的字母异位词
 * @date 2019/12/4 18:24
 *
 * 字母异位词是指由相同的字母按照不同的顺序组成的单词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Anagram {

    public static boolean isAnagram(String s, String t) {
        Map<String,Integer> integerMap = new HashMap<String, Integer>();
        for (char c:s.toCharArray()) {
            Integer num = integerMap.getOrDefault(String.valueOf(c),0);
            num++;
            integerMap.put(String.valueOf(c),num);
        }

        for (char c:t.toCharArray()) {
            Integer num = integerMap.get(String.valueOf(c));
            if(num == null){
                return false;
            }
            num--;
            if(num == 0){
                integerMap.remove(String.valueOf(c));
            }else{
                integerMap.put(String.valueOf(c),num);
            }
        }

        return integerMap.isEmpty()?true:false;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + isAnagram("anagran","nagaram") + "]");
    }

}
