package com.algorithm;

/**
 * @author admin
 * @Description: 最长连续递增序列
 * @date 2020/8/20 17:55
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 *  
 *
 * 注意：数组长度不会超过10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxLongList {

    public static int findLengthOfLCIS(int[] nums) {
        int finlaLength = 0;
        int currentLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i != 0){
                if(nums[i] > nums[i-1]){
                    currentLength++;
                }else{
                    if(currentLength > finlaLength){
                        finlaLength = currentLength;
                    }
                    currentLength = 1;
                }
            }else{
                currentLength++;
            }
        }

        if(currentLength > finlaLength){
            finlaLength = currentLength;
        }

        return finlaLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7};
        System.out.printf(findLengthOfLCIS(nums)+"");
    }
}
