package com.algorithm;

import java.util.*;

/**
 * @author admin
 * @Description:  同构字符串
 * @date 2019/11/28 20:13
 * 给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

示例 1:

输入: s = "egg", t = "add"
输出: true
示例 2:

输入: s = "foo", t = "bar"
输出: false
示例 3:

输入: s = "paper", t = "title"
输出: true
说明:
你可以假设 s 和 t 具有相同的长度。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/isomorphic-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SameStructureString {

    public static boolean isIsomorphic(String s, String t) {

        Map<String,List<Integer>> map1 = toMap(s);
        Map<String,List<Integer>> map2 = toMap(t);

        return check(t,map1) && check(s,map2);
    }

    public static Map<String,List<Integer>> toMap(String s){
        char[] chars1 = s.toCharArray();
        Map<String,List<Integer>> stringListMap = new HashMap<String, List<Integer>>();
        for (int i = 0; i < chars1.length; i++) {
            List list = stringListMap.get(String.valueOf(chars1[i]));
            if(list == null){
                list = new ArrayList();
            }
            list.add(i);
            stringListMap.put(String.valueOf(chars1[i]),list);
        }

        return stringListMap;
    }

    public static boolean check(String s,Map<String,List<Integer>> stringListMap){
        char[] chars2 = s.toCharArray();
        Iterator<List<Integer>> iterator = stringListMap.values().iterator();
        while (iterator.hasNext()){
            List<Integer> list = iterator.next();
            if(list.size() == 1) continue;
            char c = chars2[list.get(0)];
            for (int i:list) {
                if(c != chars2[i]){
                    return false;
                }
            }
        }

        return true;
    }

    //判断相同位置的字符在各自的字符串中第一次出现的位置是否相同
    public static boolean isIsomorphic1(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.indexOf(ch1[i]) != t.indexOf(ch2[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + isIsomorphic1("egg","add") + "]");
    }
}
