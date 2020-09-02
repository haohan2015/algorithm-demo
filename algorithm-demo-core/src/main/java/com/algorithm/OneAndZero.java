package com.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author admin
 * @Description: 一和零
 * @date 2020/8/27 19:05
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
 *
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 *
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 *
 * 注意:
 *
 * 给定 0 和 1 的数量都不会超过 100。
 * 给定字符串数组的长度不会超过 600。
 * 示例 1:
 *
 * 输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * 输出: 4
 *
 * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 * 示例 2:
 *
 * 输入: Array = {"10", "0", "1"}, m = 1, n = 1
 * 输出: 2
 *
 * 解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
 * 1.状态定义 定义截止前一个字符串数组，能够组装出的最大长度和所用0和1的个数
 * 2.转移方程 f(i)=
 * 3.初始状态
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneAndZero {

    public static ListNode mergeTwoLists (ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode end = null;
        while(l1 != null && l2 != null){
            ListNode node = null;
            if(l1.val > l2.val){
                node = l2;
                l2 = l2.next;
            }else{
                node = l1;
                l1 = l1.next;
            }

            if(head != null){
                end.next = node;
                end = node;
            }else{
                head = node;
                end = node;
            }
        }

        if(l2 != null){
            if(head == null){
                head = l2;
            }else{
                end.next = l2;
            }
        }

        if(l1 != null ){
            if(head == null){
                head = l1;
            }else{
                end.next = l1;
            }
        }

        return head;
    }


    public static void main(String[] args) {

    }
}
