package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @Description: 两数之和 II - 输入有序数组
 * @date 2019/11/19 18:12
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
示例:

输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoNumberSum {

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> integerMap = new HashMap();
        int[] index = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if(integerMap.containsKey(numbers[i])){
                index[0] = integerMap.get(numbers[i])+1;
                index[1] = i+1;
                return index;
            }else {
                integerMap.put(target - numbers[i],i);
            }
        }

        return index;
    }

    public static int[] twoSum1(int[] numbers, int target) {
        int[] index = new int[2];
        int minIndex = 0;
        int maxIndex = numbers.length-1;
        while (minIndex < maxIndex){
            if(numbers[minIndex] + numbers[maxIndex] == target){
                index[0] = minIndex+1;
                index[1] = maxIndex+1;
                return index;
            }else if(numbers[minIndex] + numbers[maxIndex] > target){
                maxIndex--;
            }else{
                minIndex++;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int[] index = twoSum1(numbers,9);
        System.out.println("args = [" + index[0] + "]");
        System.out.println("args = [" + index[1] + "]");

    }

}
