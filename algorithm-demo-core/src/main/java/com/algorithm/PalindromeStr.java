package com.algorithm;

/**
 * @author peng.li
 * @Description: 验证回文串
 * @date 2019/11/16 19:33
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-palindrome
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PalindromeStr {

    public static boolean isPalindrome(String s) {
        if(s == null || s.length() == 0 || s.length() == 1){
            return true;
        }

        for (int i = 0,j=s.length()-1; i < j;) {
            char c1 = s.charAt(i);
            while (!(48 <= c1 && c1 <=57) && !(97 <= c1 && c1 <=122) && !(65 <= c1 && c1 <=90) && i < j){
                i++;
                c1 = s.charAt(i);
            }

            char c2 = s.charAt(j);
            while (!(48 <= c2 && c2 <=57) && !(97 <= c2 && c2 <=122) && !(65 <= c2 && c2 <=90) && j > i){
                j--;
                c2 = s.charAt(j);
            }
            if(!String.valueOf(c1).equalsIgnoreCase(String.valueOf(c2))){
                return false;
            }else{
                i++;
                j--;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + isPalindrome("A man, a plan, a canal: Panama") + "]");
    }

}
