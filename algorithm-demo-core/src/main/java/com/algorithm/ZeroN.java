package com.algorithm;

/**
 * @author admin
 * @Description:  II. 0～n-1中缺失的数字
 * @date 2020/8/20 17:48
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZeroN {

    public static int missingNumber(int[] nums) {
        for(int i = 0 ;i < nums.length;i++){
            if(i != nums[i]){
                return i;
            }
        }

        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4,5,6,7,9};
        System.out.printf(missingNumber(nums)+"");
    }
}
