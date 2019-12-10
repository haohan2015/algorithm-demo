package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @Description: 粉刷房子
 * @date 2019/12/6 20:
 * 这道题说有n个房子，每个房子可以用红绿蓝三种颜色刷，每个房子的用每种颜色刷的花费都不同，限制条件是相邻的房子不能用相同的颜色来刷，
 * 现在让我们求刷完所有的房子的最低花费是多少。
 *
 * 这其实是一种动态规划算法思想，动态规划中有3个概念，1.最优子结构，2.边界，3.状态转移公式
 * 对于这道刷房子的题：红色费用=3，绿色费用=2，蓝色费用=5，用一个二维数组记录刷房子费用，costs[i][j]，代表刷第i+1个房子用颜色j+1时的最少费用(因为数组下标从0开始)
 * 用f(i,j)代表刷第i+1个房子用j+1个颜色的费用
 * 边界：f(0,0)=3，f(0,1)=2，f(0,2)=5
 * 状态转移公式：f(i,j)=costs[i][j] + min(f(i-1,(j+1)%3),f(i-1,(j+2)%3));
 * 最优子结构：其中f(i-1,(j+1)%3)和f(i-1,(j+2)%3)就是最优子结构
 */
public class PaintHouse {

    public static int minCost(List<List<Integer>> costs){
        if (costs.isEmpty()){
            return 0;
        }

        for (int i = 1; i < costs.size(); i++) {
            for (int j = 0; j < 3; j++) {
                costs.get(i).add(costs.get(0).get(j) + Math.min(costs.get(i - 1).get((j + 1)%3),costs.get(i - 1).get((j + 2)%3)));
            }
        }

        return Math.min(costs.get(costs.size() - 1).get(0),Math.min(costs.get(costs.size() - 1).get(1),costs.get(costs.size() - 1).get(2)));
    }

    //还有一种优化空间的方法，因为计算第n个房子的最少费用只需要知道第n-1个房子刷每种颜色的最少费用
    public static int minCost(int h,int[] colors){
        if(h <= 0){
            return 0;
        }

        int[] preHouse = new int[colors.length];
        for (int i = 0; i < colors.length; i++) {
            preHouse[i] = colors[i];
        }

        for (int i = 2; i <= h; i++) {
            int[] curHouse = new int[colors.length];
            curHouse[0] = colors[0] + Math.min(preHouse[1],preHouse[2]);
            curHouse[1] = colors[1] + Math.min(preHouse[0],preHouse[2]);
            curHouse[2] = colors[2] + Math.min(preHouse[0],preHouse[1]);
            preHouse = curHouse;
        }

        return Math.min(preHouse[0],Math.min(preHouse[1],preHouse[2]));
    }

    public static void main(String[] args) {
        List<List<Integer>> costs = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(2);
        list1.add(5);
        costs.add(list1);
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
        costs.add(list2);
        costs.add(list3);
        costs.add(list4);
        costs.add(list5);

        System.out.println("args = [" + minCost(costs) + "]");

        System.out.println("args = [" + minCost(5,new int[]{3,2,5}) + "]");
    }


}
