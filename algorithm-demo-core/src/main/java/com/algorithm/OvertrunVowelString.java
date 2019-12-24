package com.algorithm;

/**
 * @author admin
 * @Description: 反转字符串中的元音字母
 * @date 2019/12/24 18:47

编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
5个元音字母分别为：a[ei]、e[i:]、i[ ai]、o[eu]、u[ju:];
示例 1:

输入: "hello"
输出: "holle"
示例 2:

输入: "leetcode"
输出: "leotcede"
说明:
元音字母不包含字母"y"。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class OvertrunVowelString {

    public static String reverseVowels(String s) {
        if(s != null && s.length() > 1){
            char[] chars = s.toCharArray();
            int j = s.length();
            for (int i = 0; i < j; i++) {
                if("aeiouAEIOU".contains(String.valueOf(chars[i]))){
                    for (; j > i; j--) {
                        if("aeiouAEIOU".contains(String.valueOf(chars[j-1]))){
                            char temp = chars[i];
                            chars[i] = chars[j-1];
                            chars[j-1] = temp;
                            j--;
                            break;
                        }
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (char c:chars) {
                stringBuilder.append(String.valueOf(c));
            }
            s = stringBuilder.toString();
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + reverseVowels("aA") + "]");
    }
}
