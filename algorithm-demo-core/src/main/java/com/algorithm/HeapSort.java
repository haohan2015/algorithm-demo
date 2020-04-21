package com.algorithm;

import java.util.Arrays;

/**
 * @author admin
 * @Description: 堆排序
 * @date 2020/4/21 15:19
 */
public class HeapSort {


    public static void main(String[] args) {
        int[] arrays = new int[]{2,5,8,1,3,6,4};
        for (int i = arrays.length / 2 - 1; i >= 0 ; i--) {
            heapAdjust(arrays,i);
        }

        for (int i = 0; i < arrays.length; i++) {
            System.out.println("args = [" + arrays[i] + "]");
        }
    }

    public static void heapAdjust(int[] arrays,int c){
        int left = 2 * c + 1;
        int right = 2 * c + 2;
        int b = c;

        if(left < arrays.length && arrays[b] > arrays[left]){
            b = left;
        }

        if(right < arrays.length && arrays[b] > arrays[right]){
            b = right;
        }

        if(b != c){
            int temp = arrays[c];
            arrays[c] = arrays[b];
            arrays[b] = temp;
            heapAdjust(arrays,b);
        }

    }

}
