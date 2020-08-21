package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @Description: 数组的度
 * @date 2020/8/20 18:29
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1:
 *
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2:
 *
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 *
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 * 通过次数21,222提交次数39,261
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrayDegree {

    public static int findShortestSubArray(int[] nums) {

        Map<Integer, List<Integer>> maps = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = maps.get(nums[i]);
            if(list == null){
                list = new ArrayList<>();
                list.add(0);
                list.add(null);
                list.add(null);
                maps.put(nums[i],list);
            }
            list.set(0,list.get(0)+1);
            if(list.get(1)==null){
                list.set(1,i);
                list.set(2,i);
            }else{
                list.set(2,i);
            }
        }

        int maxLength = 0;
        int maxKey = 0;
        for (Map.Entry<Integer,List<Integer>> entry:maps.entrySet()) {
            if(entry.getValue().get(0) > maxLength){
                maxLength = entry.getValue().get(0);
                maxKey = entry.getKey();
            }else if(entry.getValue().get(0) == maxLength){
                if((maps.get(maxKey).get(2)-maps.get(maxKey).get(1)) > (entry.getValue().get(2) - entry.getValue().get(1))){
                    maxKey = entry.getKey();
                }
            }
        }

        return maps.get(maxKey).get(2)-maps.get(maxKey).get(1) + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1};
        System.out.printf(+findShortestSubArray(nums)+"");
    }
}
