package com.algorithm;

/**
 * @author admin
 * @Description: 回文链表
 * @date 2019/12/3 20:58
 *
 * 请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class PalindromeList {

    public static boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null){
            return true;
        }

        ListNode tempNode = head;
        int num = 1;
        while (tempNode.next != null){
            num++;
            tempNode = tempNode.next;
        }

        ListNode secondNode = head;
        tempNode = head.next;
        int middleIndex = num/2;
        while (middleIndex > 1){
            secondNode.next = tempNode.next;
            tempNode.next = head;
            head = tempNode;
            tempNode = secondNode.next;
            middleIndex--;
        }

        tempNode = head;
        middleIndex = (num + 1)/2;
        while (middleIndex > 0){
            tempNode = tempNode.next;
            middleIndex--;
        }

        middleIndex = num/2;
        while (middleIndex > 0){
            if(tempNode.val == head.val){
                tempNode = tempNode.next;
                head = head.next;
            }else{
                return false;
            }
            middleIndex--;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(3);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(2);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(4);
        listNode5.next = listNode6;
        System.out.println("args = [" + isPalindrome(listNode1) + "]");
    }

}
