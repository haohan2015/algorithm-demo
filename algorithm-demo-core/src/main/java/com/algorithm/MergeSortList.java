package com.algorithm;

import java.util.Arrays;

/**
 * @author admin
 * @Description: 合并两个有序数组
 * @date 2019/9/25 18:59
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeSortList {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = m-1; j >=0; j--) {
                if(nums1[j] > nums2[i]){
                    nums1[j + 1] = nums1[j];
                    nums1[j] = nums2[i];
                }else{
                    nums1[j + 1] = nums2[i];
                    break;
                }
            }
            if(m ==0){
                nums1[0] = nums2[i];
            }
            m++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,5,6,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{1,2,3};
        int n = 3;
        merge(nums1,m,nums2,n);
        Arrays.stream(nums1).forEach(System.out::println);
    }
}
