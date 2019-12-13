package com.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author admin
 * @Description: 单词规律
 * @date 2019/12/13 17:42
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:

输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:

输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:

输入: pattern = "abba", str = "dog dog dog dog"
输出: false
说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-pattern
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Wordlaw {

    public static boolean wordPattern(String pattern, String str) {

        if(pattern == null){
            if(str == null){
                return true;
            }

            return false;
        }

        if(str == null){
            return false;
        }

        char[] patterns = pattern.toCharArray();
        String[] strArray = str.split(" ");
        if(patterns.length != strArray.length){
            return false;
        }
        Map<String,String> relation = new HashMap<>(16);
        Set<String> strNum = new HashSet<>();
        for (int i = 0; i < patterns.length; i++) {
            if(relation.containsKey(String.valueOf(patterns[i]))){
                if(!relation.get(String.valueOf(patterns[i])).equals(strArray[i])){
                    return false;
                }
            }else{
                relation.put(String.valueOf(patterns[i]),strArray[i]);
            }

            strNum.add(strArray[i]);
        }

        return strNum.size() == relation.size()?true:false;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + wordPattern("aaa","aa aa aa aa") + "]");
    }

}
