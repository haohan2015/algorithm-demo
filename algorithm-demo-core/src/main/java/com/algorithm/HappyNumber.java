package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @Description: 快乐数
 * @date 2019/11/27 16:47
 *
 * 编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

示例: 

输入: 19
输出: true
解释:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
不是快乐数的数称为不快乐数（unhappy number），所有不快乐数的数位平方和计算，最後都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/happy-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HappyNumber {

    public static List<Integer> HappyNumberList = new ArrayList<Integer>();
    static {
        HappyNumberList.add(4);
        HappyNumberList.add(16);
        HappyNumberList.add(37);
        HappyNumberList.add(58);
        HappyNumberList.add(89);
        HappyNumberList.add(145);
        HappyNumberList.add(42);
        HappyNumberList.add(20);
    }
    public static boolean isHappy(int n) {

        if(HappyNumberList.contains(n)){
            return false;
        }

        int m = 0;
        int h = 10;
        while (n >= 10){
            int i = n%h;
            n = n / h;
            m += i*i;
        }
        m += n * n;
        if(m ==1){
            return true;
        }

        return isHappy(m);
    }

    public static void main(String[] args) {
        System.out.println("args = [" + isHappy(12) + "]");
    }
}
