package com.algorithm;

/**
 * @author admin
 * @Description: 最长回文子串
 * @date 2019/12/24 20:55
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        if(s== null || s.length() == 0){
            return s;
        }
        String[][] db = new String[s.length()][s.length()];
        int m = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            db[i][i] = "1";
            for (int j = 0; j < i; j++) {
                if(j == i){
                    db[i][j] = "1";
                }else if(i -j == 1){
                    if(s.substring(i,i+1).equals(s.substring(j,j+1))){
                        db[i][j] = "1";
                        if((i - j) > (n - m)){
                            n = i;
                            m = j;
                        }
                    }else{
                        db[i][j] = "0";
                    }
                }else{
                    if(s.substring(i,i+1).equals(s.substring(j,j+1))){
                        int h = j+1;
                        int k = i-1;
                        if(db[k][h].equals("1")){
                            db[i][j] = "1";
                            if((i - j) > (n -m)){
                                n = i;
                                m = j;
                            }
                        }else{
                            db[i][j] = "0";
                        }
                    }else{
                        db[i][j] = "0";
                    }
                }
            }
        }

        return s.substring(m,n+1);
    }

    public static void main(String[] args) {
        System.out.println("args = [" + longestPalindrome("cbbd") + "]");
    }

}
