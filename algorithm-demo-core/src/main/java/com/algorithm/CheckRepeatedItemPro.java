package com.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author admin
 * @Description: 存在重复元素 II
 * @date 2019/11/29 20:33
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。

示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:

输入: nums = [1,2,3,1,2,3], k = 2
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contains-duplicate-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckRepeatedItemPro {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j] && (j -i) <= k){
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 遍历数组，对于每个元素做以下操作：
     在散列表中搜索当前元素，如果找到了就返回 true。
     在散列表中插入当前元素。
     如果当前散列表的大小超过了 kk， 删除散列表中最旧的元素。
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> integers = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(integers.contains(nums[i])){
                return true;
            }
            integers.add(nums[i]);
            if(integers.size() > k){
                integers.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + containsNearbyDuplicate1(new int[]{1,1},2) + "]");
    }

}
