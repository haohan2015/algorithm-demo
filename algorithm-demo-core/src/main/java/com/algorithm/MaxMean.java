package com.algorithm;

/**
 * @author admin
 * @Description: 子数组最大平均数 I
 * @date 2020/8/20 18:07
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例 1:
 *
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 *
 * 注意:
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * 通过次数18,065提交次数46,223
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxMean {

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int lastSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i < k){
                sum += nums[i];
                lastSum = sum;
            }else{
                if(sum < (lastSum - nums[i - k] + nums[i])){
                    sum = lastSum - nums[i - k] + nums[i];
                    lastSum = sum;
                }else{
                    lastSum = lastSum - nums[i - k] + nums[i];
                }
            }
        }
        return new Double(sum)/k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6,8,6,8,0,4,1,2,9,9};
        System.out.printf(findMaxAverage(nums,2)+"");
    }
}
