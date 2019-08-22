package com.algorithm;

/**
 * @author admin
 * @Description: 合并两个有序链表
 * @date 2019/8/21 19:09
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newTailListNode = new ListNode(0);
        ListNode newHeadListNode = newTailListNode;
        while (l1 != null && l2 != null){
            int val1 = l1.val;
            int val2 = l2.val;
            if(val1 > val2){
                newTailListNode.next = l2;
                newTailListNode = l2;
                l2 = l2.next;
            }else if(val1 == val2){
                newTailListNode.next = l1;
                newTailListNode = l1;
                l1 = l1.next;
                newTailListNode.next = l2;
                newTailListNode = l2;
                l2 = l2.next;
            }else{
                newTailListNode.next = l1;
                newTailListNode = l1;
                l1 = l1.next;
            }
        }
        if(l1 != null){
            newTailListNode.next = l1;
        }
        if(l2 != null){
            newTailListNode.next = l2;
        }

        return newHeadListNode.next;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        ListNode result = mergeTwoLists(listNode1,listNode2);
        while (result != null){
            System.out.println("args = [" + result.val + "]");
            result = result.next;
        }
    }

}
