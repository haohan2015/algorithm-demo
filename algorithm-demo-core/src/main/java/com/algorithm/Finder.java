package com.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @Description: TODO
 * @date 2020/9/2 15:19
 */
public class Finder {

    public int findKth(int[] a, int n, int K) {
        if(n == K){
            return a[n-1];
        }
        return quickSortSub(a, 0, n-1, K);

    }

    public static void quickSort(int[] a){

    }

    private static  int partition(int[] a, int p, int r, int k) {
        int pivot = a[r];
        int i = p;
        int j = p;
        for(; j< r; j++) {
            if(a[j] > pivot) {
                if(i ==j) {
                    i++;
                } else {
                    swap(a,i,j);
                    i++;
                }
            }
        }
        swap(a,i,r);

        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int quickSortSub(int[] a,int start,int end ,int K){

        if(end - start == 1 && a[end] >= a[start]){
            return a[K];
        }
        int indexOfFirstBigThan = start+1;
        for (int i = start+1; i <= end; i++) {
            if(a[i] < a[start]){
                int temp = a[i];
                a[i] = a[indexOfFirstBigThan];
                a[indexOfFirstBigThan] = temp;
                indexOfFirstBigThan++;
            }
        }

        int temp = a[indexOfFirstBigThan -1];
        a[indexOfFirstBigThan -1] = a[start];
        a[start] = temp;
        if(indexOfFirstBigThan == K){
            return a[indexOfFirstBigThan -1];
        }else if(indexOfFirstBigThan > K){
            return quickSortSub(a,start,indexOfFirstBigThan -2,K);
        }else{
            return quickSortSub(a,indexOfFirstBigThan,end,K);
        }
    }



    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = removeNthFromEnd(listNode1,3);
        System.out.println("args = " + removeNthFromEnd(listNode1,3).val);
    }

    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode i = head;
        ListNode j = i;
        ListNode meet = null;
        while (j != null && j.next != null){
            i = i.next;
            j = j.next.next;
            if(i == j){
                meet =  i;
                break;
            }
        }

        if(meet == null){
            return null;
        }

        i = head;
        while(i != j) {
            i = i.next;
            j = j.next;
        }
        return i;
    }

    public static ListNode detectCycle1(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet = null;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                meet = fast;
                break;
            }
        }
        if(meet == null) {
            return null;
        }
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode slow = head;
        ListNode fast = head;
        int slowj = 0;
        int fastj = 0;
        ListNode slowBefore = head;
        while (slow != null){
            int i = n;
            while (i > 0){
               fast = fast.next;
               if(fast == null){
                   break;
               }
               i--;
                fastj++;
            }

            if(i > 0){
                while (slowj <= fastj-n){
                    slowBefore = slow;
                    slow = slow.next;
                    slowj++;
                }
                if(slow == head){
                    return slow.next;
                }
                slowBefore.next = slow.next;
                return head;
            }
            slowBefore = slow;
            slow = slow.next;
            slowj++;
        }
        return null;
    }

}
