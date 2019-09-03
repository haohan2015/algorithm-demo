package com.algorithm;

/**
 * @author admin
 * @Description: 最大子序和
 * @date 2019/9/3 20:18
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArraySum {


    public static int maxSubArray1(int[] nums) {
        int maxSum = 0;
        int startIndex = 0;
        int lastIndex = nums.length;
        boolean left = true;
        while (startIndex >= lastIndex){
            if(left){

            }
        }
        return maxSum;
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            int lastSum = nums[i];
            if(i == 0 || lastSum > maxSum){
                maxSum = lastSum;
            }
            for (int j = i+1; j < nums.length; j++) {
                lastSum += nums[j];
                if(lastSum > maxSum){
                    start = i;
                    end = j;
                    maxSum = lastSum;
                }
            }
        }
        System.out.println("start = [" + start + "]");
        System.out.println("end = [" + end + "]");
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1};
        System.out.println("args = [" + maxSubArray(nums) + "]");
    }

}
