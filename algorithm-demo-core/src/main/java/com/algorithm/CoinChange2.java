package com.algorithm;

/**
 * @author admin
 * @Description:  硬币找零之二
 * @date 2020/6/28 9:48
 *
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)

示例1:

输入: n = 5
输出：2
解释: 有两种方式可以凑成总金额:
5=5
5=1+1+1+1+1
示例2:

输入: n = 10
输出：4
解释: 有四种方式可以凑成总金额:
10=10
10=5+5
10=5+1+1+1+1+1
10=1+1+1+1+1+1+1+1+1+1
说明：

注意:

你可以假设：

0 <= n (总金额) <= 1000000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange2 {

    public final static int[] coins = new int[]{0,1,5,10,25};

    public static int waysToChange(int n) {
        if(n == 0){
            return 0;
        }
        int[][] dp = new int[n+1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j];
                dp[i][j] += (coin == j ? 1:(coin > j ?0:dp[i][j-coin]));
                if(n == j && coin == n){
                    break;
                }

            }
        }

        return dp[coins.length-1][n]%1000000007;
    }

    public static int waysToChange1(int n) {
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coin])%1000000007;

            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println("args = [" + waysToChange1(900750) + "]");
    }

}
