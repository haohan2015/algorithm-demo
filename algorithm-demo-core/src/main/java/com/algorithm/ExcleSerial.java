package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @Description: Excel表列序号
 * @date 2019/11/21 18:20
 *
 * 给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...
示例 1:

输入: "A"
输出: 1
示例 2:

输入: "AB"
输出: 28
示例 3:

输入: "ZY"
输出: 701

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/excel-sheet-column-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ExcleSerial {


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
    static Map<String,Integer> integerMap = new HashMap<String, Integer>();
    static {
            integerMap.put("A",1);
            integerMap.put("B",2);
            integerMap.put("C",3);
            integerMap.put("D",4);
            integerMap.put("E",5);
            integerMap.put("F",6);
            integerMap.put("G",7);
            integerMap.put("H",8);
            integerMap.put("I",9);
            integerMap.put("J",10);
            integerMap.put("K",11);
            integerMap.put("L",12);
            integerMap.put("M",13);
            integerMap.put("N",14);
            integerMap.put("O",15);
            integerMap.put("P",16);
            integerMap.put("Q",17);
            integerMap.put("R",18);
            integerMap.put("S",19);
            integerMap.put("T",20);
            integerMap.put("U",21);
            integerMap.put("V",22);
            integerMap.put("W",23);
            integerMap.put("X",24);
            integerMap.put("Y",25);
            integerMap.put("Z",26);
        }

    public static int titleToNumber(String s) {
        int lineNum = 0;
        int multiple = 1;
        while (s.length() > 0){
            String s1 = s.substring(s.length()-1,s.length());
            s = s.substring(0,s.length() -1);
            int num = integerMap.get(s1);
            lineNum += multiple * num;
            multiple *= 26;
        }
        return lineNum;
    }

    public static int titleToNumber1(String s) {
        int lineNum = 0;
        int multiple = 1;
        char[] chars = s.toCharArray();
        int index = chars.length-1;
        while (index >= 0){
            String s1 = String.valueOf(chars[index]);
            index--;
            int num = integerMap.get(s1);
            lineNum += multiple * num;
            multiple *= 26;
        }
        return lineNum;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + titleToNumber1("AB") + "]");
    }
}
