package com.algorithm;

import java.util.Arrays;

/**
 * @author admin
 * @Description: 连续子数组的最大和
 * @date 2020/8/25 11:26
 *  输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 1.状态定义
 * 2.转移方程
 * 3.初始状态
 */
public class ArraySum {

    public static int maxSubArray1(int[] nums) {
        int maxSum = -100;
        int[] arrays = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int currentSum =  maxSubArray1(nums,i,arrays);
            if(maxSum < currentSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    public static int maxSubArray1(int[] nums,int num,int[] arrays){
        int maxSum = -100;
        for (int i = num; i < nums.length; i++) {
            int s = arrays[i - num];
            int currentSum = arrays[i - num]+nums[i];
            arrays[i-num] = currentSum;
            if(maxSum < currentSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    public static int maxSubArray(int[] nums) {
        int[][] arrays = new int[nums.length][2];
        int maxSum = -100;
        for (int i = 0; i < nums.length; i++) {
            arrays[i][0] = nums[i];
            if(maxSum < nums[i]){
                maxSum = nums[i];
            }
            if(i > 0){
                arrays[i-1][1] = nums[i-1] + nums[i];
                if(maxSum < arrays[i-1][1]){
                    maxSum = nums[i];
                }
            }
        }




        return maxSum;

    }

    public static int maxSubArray2(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if(i == 0){
                nums[i] = nums[i];
            }else{
                if(nums[i-1] > 0){
                    nums[i] = nums[i] + nums[i-1];
                }else{
                    nums[i] = nums[i];
                }
            }
        }

        int maxNum = -100 ;
        for (int i = 0; i < nums.length; i++) {
            if(maxNum < nums[i]){
                maxNum = nums[i];
            }
        }
        return maxNum;

    }


    public static void main(String[] args) {
        System.out.println("args = " + maxSubArray2(new int[]{-2,1,3}));
    }

}
