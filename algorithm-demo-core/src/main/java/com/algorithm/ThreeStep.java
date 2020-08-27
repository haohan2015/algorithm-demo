package com.algorithm;

import java.util.Arrays;

/**
 * @author admin
 * @Description: 三步问题
 * @date 2020/8/27 17:36
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。
 * 结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 * 示例2:
 *
 *  输入：n = 5
 *  输出：13
 * 提示:
 *
 * n范围在[1, 1000000]之间
 * 1.状态定义 int[] ways，ways[i]等于i层楼梯的方式数量
 * 2.状态转移方程 f(i)=f(i-3)+f(i-2)+f(f-1)
 * 3.初始状态 f(1) = 1，f(2)=2，f(3)=4
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeStep {

    public static int waysToStep(int n) {

        if(n == 1){
            return 1;
        }

        if(n == 2){
            return 2;
        }

        if( n == 3){
            return 4;
        }

        long[] ways = new long[n+1];
        ways[1] = 1;
        ways[2] = 2;
        ways[3] = 4;
        for (int i = 4; i <= n; i++) {
            ways[i] = (ways[i-1] + ways[i-2] + ways[i-3])%1000000007;
        }
        return (int) ways[n];
    }

    public static void main(String[] args) {
        System.out.println("args = " + waysToStep(61));
    }

}
