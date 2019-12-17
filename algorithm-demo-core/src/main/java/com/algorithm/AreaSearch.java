package com.algorithm;

/**
 * @author admin
 * @Description: 区域和检索 - 数组不可变
 * @date 2019/12/17 20:38
 *

给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

示例：

给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
说明:

你可以假设数组不可变。
会多次调用 sumRange 方法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/range-sum-query-immutable
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AreaSearch {

    private int[] nums;

    public AreaSearch(int[] nums) {
        if(nums != null && nums.length > 0){
            this.nums = new int[nums.length+1];
            this.nums[0] = nums[0];
            for (int i = 0; i < nums.length-1; i++) {
                this.nums[i+1] = this.nums[i] + nums[i+1];
            }
        }
    }

    public int sumRange(int i, int j) {
        if(nums == null){
            return 0;
        }

        if(i == 0){
            return nums[j];
        }else {
            return nums[j]-nums[i-1];
        }
    }

    public static void main(String[] args) {
        System.out.println("args = [" + new AreaSearch(new int[]{1,2,3,4,5}).sumRange(0,3) + "]");
    }

}
