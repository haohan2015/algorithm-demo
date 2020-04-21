package com.algorithm;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author admin
 * @Description: 岛屿数量
 * @date 2020/4/20 19:28
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

示例 1:

输入:
11110
11010
11000
00000
输出: 1
示例 2:

输入:
11000
11000
00100
00011
输出: 3
解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumIslands {

    public static int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char data = grid[i][j];
                if(data == '1'){
                    traverse(grid,0,0,i,j);
                    num++;
                }
            }

        }

        return num;
    }

    private static void traverse(char[][] grid,int pi,int pj,int ci,int cj){
        if(grid[ci][cj] == '1'){
            grid[ci][cj] = '2';
        }else{
            return;
        }

        if((cj + 1) < grid[0].length && (pi != ci || pj !=(cj + 1))){
            traverse(grid,ci,cj,ci,cj+1);
        }

        if((ci + 1) < grid.length && (pi != (ci+1) || pj !=cj)){
            traverse(grid,ci,cj,ci+1,cj);
        }

        if((cj - 1) >= 0 && (pi != ci || pj !=(cj - 1))){
            traverse(grid,ci,cj,ci,cj-1);
        }

        if((ci - 1) >= 0 && (pi != (ci-1) || pj !=cj)){
            traverse(grid,ci,cj,ci-1,cj);
        }

    }

    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("100");
        BigDecimal bigDecimal2 = new BigDecimal("100.00");
        BigDecimal bigDecimal3 = new BigDecimal("100.16");
        BigDecimal bigDecimal4 = new BigDecimal("100.14");
        BigDecimal bigDecimal5 = new BigDecimal("100.1862355");
        BigDecimal bigDecimal6 = new BigDecimal("100.143");
        BigDecimal bigDecimal7 = new BigDecimal("7.143");
        BigDecimal bigDecimal8 = new BigDecimal("7.02");
        BigDecimal bigDecimal9 = new BigDecimal("7.12");
        System.out.println("args = [" + bigDecimal1.setScale(2, RoundingMode.FLOOR) + "]");
        System.out.println("args = [" + bigDecimal2.setScale(2, RoundingMode.FLOOR) + "]");
        System.out.println("args = [" + bigDecimal3.setScale(2, RoundingMode.FLOOR) + "]");
        System.out.println("args = [" + bigDecimal4.setScale(2, RoundingMode.FLOOR) + "]");
        System.out.println("args = [" + bigDecimal5.setScale(2, RoundingMode.FLOOR) + "]");
        System.out.println("args = [" + bigDecimal6.setScale(2, RoundingMode.FLOOR) + "]");
        System.out.println("args = [" + bigDecimal7.setScale(2, RoundingMode.FLOOR) + "]");
        System.out.println("args = [" + bigDecimal8.setScale(2, RoundingMode.FLOOR) + "]");
        System.out.println("args = [" + bigDecimal9.setScale(2, RoundingMode.FLOOR) + "]");
    }
}
