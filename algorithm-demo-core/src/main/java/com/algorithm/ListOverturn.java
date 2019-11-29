package com.algorithm;

/**
 * @author admin
 * @Description: 反转链表
 * @date 2019/11/29 18:58
 * 反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ListOverturn {

    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode newHead = null;
        while (head != null){
            ListNode tempNewHead = newHead;
            newHead = head;
            head = head.next;
            newHead.next = tempNewHead;
        }

        head = newHead;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        reverseList(listNode1);

        System.out.println("args = [" + args + "]");

    }
}
