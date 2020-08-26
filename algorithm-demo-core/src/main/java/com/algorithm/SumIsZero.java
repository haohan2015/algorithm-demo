package com.algorithm;

import java.util.Arrays;

/**
 * @author admin
 * @Description: 和为零的N个唯一整数
 * @date 2020/8/24 18:49
 * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
 *
 * 示例 1：
 *
 * 输入：n = 5
 * 输出：[-7,-1,1,3,4]
 * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：[-1,0,1]
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumIsZero {

    public static int[] sumZero(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n/2; i++) {
            arr[i] = n/2 - i;
            arr[n-i-1] = 0 - arr[i];
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = sumZero(4);
        Arrays.asList(arr).forEach(i-> System.out.println("args = " + i));
    }
}
