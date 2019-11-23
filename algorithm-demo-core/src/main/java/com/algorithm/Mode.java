package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @Description: 求众数
 * @date 2019/11/21 17:50
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Mode {

    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> integerMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(integerMap.containsKey(nums[i])){
                int num = integerMap.get(nums[i])+1;
                if(num >= (nums.length/2 + 1)){
                    return nums[i];
                }
                integerMap.put(nums[i],num);
            }else{
                integerMap.put(nums[i],1);
            }
        }

        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println("args = [" + majorityElement(new int[]{2,2,1,1,1,2,2}) + "]");
    }

}
