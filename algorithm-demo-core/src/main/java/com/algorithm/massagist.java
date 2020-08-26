package com.algorithm;

import java.util.Arrays;

/**
 * @author admin
 * @Description: 按摩师
 * @date 2020/8/26 16:52
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 * 1.状态定义 int[] sum,sum[i]是前i的元素的最大值
 * 2.转移方程 sum[i] = max(f(i-1),(f(i-2) + nums[i]))
 * 3.初始状态 sum[0] = num[0]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class massagist {

    public static int massage(int[] nums) {
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(i == 0){
                sum[i] = nums[i];
            }else if(i == 1){
                if(sum[0] > nums[1]){
                    sum[1] = sum[0];
                }else{
                    sum[1] = nums[1];
                }

            }else{
                if((sum[i-2] + nums[i]) > sum[i-1]){
                    sum[i] = sum[i-2] + nums[i];
                }else{
                    sum[i] = sum[i-1];
                }
            }
        }

        return sum[sum.length-1];
    }

    public static int massage1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int sum1 = nums[0];
        int sum2 = sum1>nums[1]?sum1:nums[1];
        for (int i = 2; i < nums.length; i++) {
            if((sum1 + nums[i]) > sum2){
                int temp = sum2;
                sum2 = sum1 + nums[i];
                sum1 = temp;
            }else{
                sum1 = sum2;
            }
        }

        return sum1>sum2?sum1:sum2;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,1,2};
        System.out.println("args = " + massage1(nums));
    }

}
