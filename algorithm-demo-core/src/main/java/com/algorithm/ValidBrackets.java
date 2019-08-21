package com.algorithm;

import java.util.Stack;

/**
 * @author admin
 * @Description: TODO
 * @date 2019/8/20 20:24
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidBrackets {

    public static boolean isValid(String s) {
        char[] charArray = new char[s.length()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if(currentChar == ')' || currentChar == ']' || currentChar == '}'){
                if(currentChar == ')' && (j <= 0 || charArray[j - 1] != '('))
                    return false;
                if(currentChar == ']' && (j <= 0 || charArray[j - 1] != '['))
                    return false;
                if(currentChar == '}' && (j <= 0 || charArray[j - 1] != '{'))
                    return false;
                j--;
            }else{
                charArray[j] = currentChar;
                j++;
            }

        }
        return j > 0?false:true;
    }

    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if(currentChar == ')' || currentChar == ']' || currentChar == '}'){
                if(currentChar == ')' && (stack.isEmpty() || stack.peek() != '('))
                    return false;
                if(currentChar == ']' && (stack.isEmpty() || stack.peek() != '['))
                    return false;
                if(currentChar == '}' && (stack.isEmpty() || stack.peek() != '{'))
                    return false;
                stack.pop();
            }else{
                stack.push(currentChar);
            }

        }
        return stack.isEmpty()?true:false;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + isValid1("]") + "]");
    }

}
