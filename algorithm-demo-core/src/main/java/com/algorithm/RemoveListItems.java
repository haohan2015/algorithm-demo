package com.algorithm;

/**
 * @author admin
 * @Description: 移除链表元素
 * @date 2019/11/27 19:33
 * 删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 */
public class RemoveListItems {

    public static ListNode removeElements(ListNode head, int val) {

        if(head == null){
            return head;
        }

        ListNode preNode = head;
        while (preNode.next != null){
            if(preNode.next.val == val){
                preNode.next = preNode.next.next;
            }else{
                preNode = preNode.next;
            }
        }

        if(head.val == val){
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(6);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(3);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(4);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(5);
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(6);
        listNode6.next = listNode7;
        ListNode listNode = removeElements(listNode1,6);

        System.out.println("args = [" + listNode.val + "]");
    }
}
