package com.algorithm;

/**
 * @author admin
 * @Description: 解码方法
 * @date 2020/1/7 20:30
 *
一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DecodeMethod {
    /**
     * f(n)代表s长度为n时，有f(n)种解码方式
     * f(1)=1
     * f(2)=f(1) + (s[0]s[1] <= 26:1?0)
     * f(n)=f(n-1) + (s[n-1]s[n] <= 26:f(n-2)?0);
     */
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int f1 = 0;
        int f2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.substring(i,i+1).equals("0")){
                if(i == 0 || Integer.valueOf(s.substring(i-1,i+1)) > 26 || Integer.valueOf(s.substring(i-1,i+1)) == 0){
                    return 0;
                }
                f2 = f1;
            }else{
                if(i == 0){
                    f1 = 1;
                    f2 = 1;
                }else{
                    int temp = (s.substring(i-1,i).equals("0")?f1:(f2 + ((Integer.valueOf(s.substring(i-1,i+1))<=26)?f1:0)));
                    f1 = f2;
                    f2 = temp;
                }
            }
        }
        return f2;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + numDecodings("101") + "]");
    }
}
