package com.algorithm;

/**
 * @author admin
 * @Description: 报数
 * @date 2019/9/2 18:05
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。

 

示例 1:

输入: 1
输出: "1"
示例 2:

输入: 4
输出: "1211"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-and-say
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class CountOff {

    public static String countAndSay(int n) {

        if(n == 1){
            return "1";
        }
        String lastResult = countAndSay(n -1);
        String[] result = new String[lastResult.length() * 2];
        int index = 1;
        for (int i = 0; i < lastResult.length(); i++) {

            if(result[index] != null && result[index].equals(String.valueOf(lastResult.charAt(i)))){
                result[index - 1] = String.valueOf(Integer.valueOf(result[index - 1]) + 1);
            }else if(result[index] == null){
                result[index -1] = "1";
                result[index] = String.valueOf(lastResult.charAt(i));
            }else{
                index += 2;
                result[index -1] = "1";
                result[index] = String.valueOf(lastResult.charAt(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str:result) {
            if(str != null){
                stringBuilder.append(str);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        result.append(1).append(2).append(3);
        System.out.println("args = [" + result.charAt(2) + "]");
        System.out.println("args = [" + countAndSay(5) + "]");
    }

}
