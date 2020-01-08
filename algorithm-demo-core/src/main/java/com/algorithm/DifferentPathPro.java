package com.algorithm;

/**
 * @author admin
 * @Description: 不同路径 II
 * @date 2020/1/8 20:12
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

网格中的障碍物和空位置分别用 1 和 0 来表示。

说明：m 和 n 的值均不超过 100。

示例 1:

输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DifferentPathPro {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int m = obstacleGrid.length;
        int[][] nums = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(obstacleGrid[j][i] == 1){
                    nums[j][i] = 0;
                    continue;
                }
                int first = 0;
                if(j - 1 >= 0){
                    first = nums[j-1][i];
                }

                int top = 0;
                if(i - 1 >= 0){
                    top = nums[j][i-1];
                }

                if(i == 0 && j == 0){
                    nums[j][i] = 1;
                }else{
                    nums[j][i] = first + top;
                }
            }
        }

        return nums[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println("args = [" + uniquePathsWithObstacles(new int[][]{{0,0}}) + "]");
    }
}
