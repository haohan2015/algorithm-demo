package com.algorithm;

/**
 * @author admin
 * @Description: 3的幂
 * @date 2019/12/18 18:55
 *

给定一个整数，写一个函数来判断它是否是 3 的幂次方。

示例 1:

输入: 27
输出: true
示例 2:

输入: 0
输出: false
示例 3:

输入: 9
输出: true
示例 4:

输入: 45
输出: false
进阶：
你能不使用循环或者递归来完成本题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/power-of-three
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreePower {

    /**
     *
     * 因为int最大是2147483647，而小于2147483647的最大3的幂是19也就是1162261467
     * 因为 3 是质数，所以 1162261467的除数只能是3的x次幂，所以只要能被整除就代表是3的幂
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
