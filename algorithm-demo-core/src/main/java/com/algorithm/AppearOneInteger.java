package com.algorithm;

/**
 * @author peng.li
 * @Description: 只出现一次的数字
 * @date 2019/11/17 14:09
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/single-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AppearOneInteger {

    public static int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] == nums[i] && i != j){
                    break;
                }
                if(j == nums.length -1){
                    return nums[i];
                }
            }
        }

        return 0;
    }


    public static int singleNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if(nums[j+1] < nums[j]){
                    int value = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = value;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(i == nums.length -1){
                return nums[nums.length-1];
            }
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
            i++;
        }

        return nums[nums.length-1];
    }

    /**
     * 概念
     如果我们对 0 和二进制位做 XOR 运算，得到的仍然是这个二进制位
     a ^ 0 = a
     如果我们对相同的二进制位做 XOR 运算，返回的结果是 0
     a ^ a = 0
     XOR 满足交换律和结合律
    a^b^a=(a^a)^b=0^b=b
     所以我们只需要将所有的数进行 XOR 操作，得到那个唯一的数字。

     作者：LeetCode
     链接：https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + singleNumber2(new int[]{4,1,2,1,2}) + "]");
    }
}
