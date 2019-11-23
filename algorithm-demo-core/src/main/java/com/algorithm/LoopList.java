package com.algorithm;

import java.util.HashSet;

/**
 * @author admin
 * @Description: 环形链表
 * @date 2019/11/18 17:58
 * 给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

 

示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。

示例 2：

输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。

示例 3：

输入：head = [1], pos = -1
输出：false
解释：链表中没有环。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/linked-list-cycle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LoopList {

    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<ListNode>();
        while (head != null){
            if(listNodes.contains(head)){
                return true;
            }else{
                listNodes.add(head);
                head = head.next;
            }
        }
        return false;
    }

    public static boolean hasCycle1(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode first = head;
        ListNode second = head.next;
        while (first != null && second != null){
            if(first == second){
                return true;
            }

            first= first.next;
            if(second.next == null){
                return false;
            }
            second = second.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode1;
        /*ListNode listNode3 = new ListNode(0);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(-4);
        listNode3.next = listNode4;
        listNode4.next = listNode2;*/
        System.out.println("args = [" + hasCycle1(listNode1) + "]");

    }

}
