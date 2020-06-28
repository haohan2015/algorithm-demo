package com.algorithm;

import java.lang.reflect.Method;

/**
 * @author admin
 * @Description:
 * @date 2020/6/23 13:43
 *
 */
public class Specie {

    public static int waysToChange(int[] coins,int n) {
        if(coins.length == 0){
            return 0;
        }

        if(n <= 0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int current = min;
            if(n < coins[i]){
                continue;
            }

            if(n == coins[i]){
                current = 1;
            }else{
                current = waysToChange(coins,n - coins[i])+1;
            }

            min = Math.min(min,current);
        }

        return min == Integer.MAX_VALUE?-1:min;
    }

    public static int waysToChange1(int[] coins,int n){

        if(coins.length == 0){
            return 0;
        }

        if(n <= 0){
            return 0;
        }

        int[] memo = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            memo[i] = Integer.MAX_VALUE;
        }

        waysToChangeOfMemo(memo,coins,n);

        return memo[n]==Integer.MAX_VALUE?-1:memo[n];
    }

    public static int waysToChangeOfMemo(int[] memo,int[] coins,int n){
        if(memo[n] != Integer.MAX_VALUE){
            return memo[n];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int current = min;
            if(n < coins[i]){
                continue;
            }

            if(n == coins[i]){
                current = 1;
            }else{
                current = waysToChangeOfMemo(memo,coins,n - coins[i])+1;
            }

            min = Math.min(min,current);
        }

        memo[n] = min;

        return min;

    }

    public static int waysToChangeDP(int[] coins,int n) {

        if(coins.length == 0){
            return 0;
        }

        if(n <= 0){
            return 0;
        }

        int[] memo = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            memo[i] = n+1;
        }

        memo[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i >= coins[j]){
                    memo[i] = Math.min(memo[i],memo[i - coins[j]] + 1);
                }
            }
        }

        return memo[n] == (n+1)?-1:memo[n];

    }


    public static void main(String[] args) {
        System.out.println("args = [" + waysToChangeDP(new int[]{1,2,5},11) + "]");
    }

}
