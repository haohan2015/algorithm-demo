package com.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author admin
 * @Description: 存在重复元素
 * @date 2019/11/29 19:13
 * 给定一个整数数组，判断是否存在重复元素。

如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

示例 1:

输入: [1,2,3,1]
输出: true
示例 2:

输入: [1,2,3,4]
输出: false
示例 3:

输入: [1,1,1,3,3,4,3,2,4,2]
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contains-duplicate
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckRepeatedItem {

    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i-1; j >=0; j--) {
                if(temp == nums[j]){
                    return true;
                }else if(temp < nums[j]){
                    nums[i] = nums[j];
                }else{
                    nums[j+1] = temp;
                }
            }
        }

        return false;
    }

    public static boolean containsDuplicate1(int[] nums) {
        Set<Integer> integers = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(integers.contains(nums[i])){
                return true;
            }

            integers.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + containsDuplicate1(new int[]{1,2,3,1}) + "]");
    }
}
