package com.algorithm;

/**
 * @author admin
 * @Description: Excel表列名称
 * @date 2019/11/19 19:13
 *
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。

    例如，

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
    示例 1:

    输入: 1
    输出: "A"
    示例 2:

    输入: 28
    输出: "AB"
    示例 3:

    输入: 701
    输出: "ZY"

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/excel-sheet-column-title
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ExcleLineName {

    public static String convertToTitle(int n) {
        String[] strings = new String[]{"","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String  str = "";
        while (n > 26){
            int i = n % 26 !=0?n % 26:26;
            n = (n -i) / 26;
            str = strings[i] + str;
        }

        return strings[n] + str;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + convertToTitle(703) + "]");
    }

}
