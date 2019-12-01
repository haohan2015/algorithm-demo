package com.algorithm;

/**
 * @author admin
 * @Description: 计数质数
 * @date 2019/11/27 20:18
 * 统计所有小于非负整数 n 的质数的数量。

示例:

输入: 10
输出: 4
解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class PrimeNumber {

    public static int countPrimes(int n) {
        int num = 0;
        for (int i = 2; i < n ; i++) {
            if(isPrimeNumber(i)){
                System.out.println("n = [" + i + "]");
                num++;
            }
        }

        return num;
    }

    public static boolean isPrimeNumber(int n){
        for (int i = 2; i < n/2 + 1; i++) {
            if(n != i && n % i ==0){
                return false;
            }

            if(i * i > n){
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + countPrimes(1000) + "]");
    }
}
