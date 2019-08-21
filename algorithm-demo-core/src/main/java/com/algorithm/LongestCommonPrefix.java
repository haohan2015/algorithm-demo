package com.algorithm;

/**
 * @author admin
 * @Description: TODO
 * @date 2019/8/19 19:23
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-prefix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        char c = '0';
        int j = 0;
        for (int i = 0; i < strs.length; i++) {
            if(j >= strs[i].length()){
                return strs[0].substring(0,j);
            }
            char m = strs[i].charAt(j);
            if(c == '0'){
                c = m;
            }

            if(c == m){
                if(i == (strs.length -1)){
                    j++;
                    c = '0';
                    i = -1;
                }
                continue;
            }else{
                return strs[0].substring(0,j);
            }

        }
        return "";
    }

    public static String longestCommonPrefix1(String[] strs) {
        int j = 0;
        for (int i = 0; i < strs.length; i++) {
            if(j >= strs[i].length()){
                return strs[0].substring(0,j);
            }
            char m = strs[i].charAt(j);
            char c = i == 0 ? strs[0].charAt(j):strs[i-1].charAt(j);
            if(c != m){
                return strs[0].substring(0,j);
            }

            if(i == (strs.length -1)){
                j++;
                i = -1;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println("args = [" + longestCommonPrefix1(new String[]{"flower","flow","flight"}) + "]");
    }
}
