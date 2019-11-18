package com.algorithm;

/**
 * @author peng.li
 * @Description: 买卖股票的最佳时机 II
 * @date 2019/11/16 16:39
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
示例 2:

输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
示例 3:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class BestStock2 {

    public static int maxProfit(int[] prices) {
        return profitCalculate(prices,0);
    }

    //就是找到所以连续的峰谷差额之和，例如[7, 1, 5, 3, 6, 4]，6-1<=((5-1) + (6 -3))
    public static int maxProfit1(int[] prices) {
        int maxPrices = 0;
        int i = 0;
        while (i < prices.length - 1){
            //寻找山谷
            while ((i < prices.length -1) && prices[i + 1] < prices[i]) i++;
            int valley = prices[i];
            //训超山谷后面的第一个山峰
            while ((i < prices.length - 1) && prices[i + 1] > prices[i]) i++;
            maxPrices += prices[i] - valley;
        }

        return maxPrices;
    }

    //是maxProfit1改良，连续封峰谷之差等于峰谷之间连续的坡度查，例如[1,2,3],3 = 2-1 + 3-2;
    public static int maxProfit2(int[] prices) {
        int maxPrices = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]){
                maxPrices += prices[i] - prices[i -1];
            }
        }

        return maxPrices;
    }

    public static int profitCalculate(int[] prices,int startIndex){
        if(startIndex >= prices.length){
            return 0;
        }

        int maxProfit = 0;
        for (int i = startIndex; i < prices.length; i++) {
            int casualMaxProfit = 0;
            for (int j = startIndex + 1; j < prices.length; j++) {
                if(prices[j] > prices[i]){
                    int profit = prices[j] -prices[i] + profitCalculate(prices,j+1);
                    if(profit > casualMaxProfit){
                        casualMaxProfit = profit;
                    }
                }
            }
            if(casualMaxProfit > maxProfit){
                maxProfit = casualMaxProfit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + maxProfit2(new int[]{1,2,3,4,5,6}) + "]");
    }

}
