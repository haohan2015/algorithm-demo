package com.algorithm;

/**
 * @author admin
 * @Description: 统计「优美子数组」
 * @date 2020/4/21 19:22
 * 给你一个整数数组 nums 和一个整数 k。

如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。

请返回这个数组中「优美子数组」的数目。

示例 1：

输入：nums = [1,1,2,1,1], k = 3
输出：2
解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
示例 2：

输入：nums = [2,4,6], k = 1
输出：0
解释：数列中不包含任何奇数，所以不存在优美子数组。
示例 3：

输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
输出：16

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YouMeiZiArray {

    public static int numberOfSubarrays(int[] nums, int k) {
        if(nums.length < k || k <= 0){
            return 0;
        }
        int[] indexs = new int[nums.length];
        int tail = 0;
        for (int i = 0; i < nums.length; i++) {
            if((nums[i] & 1) == 1){
                indexs[tail] = i;
                tail++;
            }
        }

        if(tail < k){
            return 0;
        }

        int count = 0;
        for (int i = 0; i <= tail-k; i++) {
            int l = indexs[i];
            int h = indexs[i+k-1];

            int pl = -1;
            if(i-1 >= 0){
                pl = indexs[i-1];
            }

            int nl = nums.length;
            if(i+k < tail){
                nl = indexs[i+k];
            }

            count += (l-pl)*(nl - h);
        }

        return count;
    }


    public static int getNum(int[] nums, int i,int j){
        int num = 0;
        for (int k = j; k <nums.length ; k++) {
            if((k == j && (nums[i] & 1) == 1) || (nums[i] & 1) == 0){
                for (int m = i; m >= 0 ; m--) {
                    if((m == i && (nums[i] & 1) == 1) || (nums[i] & 1) == 0){
                        num++;
                    }else{
                        break;
                    }
                }
            }else {
                break;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,6};
        System.out.println("args = [" + numberOfSubarrays(nums,1) + "]");
    }

}
