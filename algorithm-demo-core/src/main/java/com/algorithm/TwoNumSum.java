package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @Description: 两数之和
 * @date 2019/8/6 16:23
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TwoNumSum {

    public static int[] twoNumSum(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            int secondNum = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] == secondNum){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static int[] twoNumSum1(int[] nums, int target){
        Map<String,Integer> stringMap = new HashMap<String,Integer>();
        for (int i = 0; i < nums.length; i++) {
            stringMap.put(String.valueOf(nums[i]),i);
        }

        for (int i = 0; i < nums.length; i++) {
            int remainNum = target - nums[i];
            if(stringMap.containsKey(String.valueOf(remainNum)) && stringMap.get(String.valueOf(remainNum)) != i){
                return new int[]{i,stringMap.get(String.valueOf(remainNum))};
            }
        }
        return null;
    }

    public static int[] twoNumSum3(int[] nums, int target){
        Map<String,Integer> stringMap = new HashMap<String,Integer>();
        for (int i = 0; i < nums.length; i++) {
            int remainNum = target - nums[i];
            if(stringMap.containsKey(String.valueOf(remainNum))){
                return new int[]{stringMap.get(String.valueOf(remainNum)),i};
            }else{
                stringMap.put(String.valueOf(nums[i]),i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] sumArray = new int[]{3,2,4};
        int target = 6;
        int[] resultArray = twoNumSum3(sumArray,target);
        System.out.print("[");
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(","+resultArray[i]);
        }
        System.out.print("]");

        System.out.println("args = [" + Integer.toBinaryString(3) + "]");
        System.out.println("args = [" + Integer.toBinaryString(-3) + "]");
        System.out.println(0b011);
    }

}
