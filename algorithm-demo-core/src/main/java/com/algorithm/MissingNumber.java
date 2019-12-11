package com.algorithm;

/**
 * @author admin
 * @Description: 缺失数字
 * @date 2019/12/11 20:27
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:

输入: [3,0,1]
输出: 2
示例 2:

输入: [9,6,4,2,3,5,7,0,1]
输出: 8
说明:
你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/missing-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int sum = (nums.length * (nums.length + 1)) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + missingNumber(new int[]{9,6,4,2,3,5,7,0,1}) + "]");
    }
}
