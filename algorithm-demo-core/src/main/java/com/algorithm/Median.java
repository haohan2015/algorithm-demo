package com.algorithm;

/**
 * @author peng.li
 * @Description: 中位数
 * @date 2019/8/24 10:15
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Median {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int index1 = (totalLength + 1) /2;
        int index2 = (totalLength + 2) /2;
        double first = 0;
        int nums1Index = 0;
        int nums2Index = 0;
        for (int i = 0; i < totalLength;) {

            int nums1Value = Integer.MAX_VALUE;
            if(nums1Index < nums1.length){
                nums1Value = nums1[nums1Index];
            }

            int nums2Value = Integer.MAX_VALUE;
            if(nums2Index < nums2.length){
                nums2Value = nums2[nums2Index];
            }

            int value;
            if(nums1Value >= nums2Value){
                nums2Index++;
                value = nums2Value;
            }else{
                nums1Index++;
                value = nums1Value;
            }
            i++;
            if(index1 == i){
                first += value;
            }

            if(index2 == i){
                first += value;
                break;
            }
        }
        return first / 2;
    }

    public static void main(String[] args) {
        //122345
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println("args = [" + findMedianSortedArrays(nums1,nums2) + "]");
    }

}
