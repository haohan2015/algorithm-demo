package com.algorithm;

/**
 * @author admin
 * @Description: Paint Fence 粉刷篱笆
 * @date 2019/12/18 20:34
这道题让我们粉刷篱笆，有n个部分需要刷，有k种颜色的油漆，规定了不能有超过两个的相同颜色涂的部分，问我们总共有多少种刷法。


 */
public class PaintFence {

    public static int numWays(int n, int k) {

        if(n == 0){
            return 0;
        }

        int same = 0;
        int diff = k;
        for (int i = 2; i <= n; i++) {
            int t = diff;
            diff = (same + diff)*(k-1);
            same = t;
        }

        return same + diff;
    }

    public static int numWays1(int n, int k) {
        if (n == 0) return 0;
        int same = 0, diff = k;
        for (int i = 2; i <= n; ++i) {
            int t = diff;
            diff = (same + diff) * (k - 1);
            same = t;
        }
        return same + diff;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + numWays(20,3) + "]");
        System.out.println("args = [" + numWays1(20,3) + "]");
    }

}
