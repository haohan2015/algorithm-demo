package com.algorithm;

import java.util.Arrays;

/**
 * @author admin
 * @Description: 缀点成线
 * @date 2020/8/21 14:18
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 *
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Line {

    public static boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 0 || coordinates.length == 1 || coordinates.length == 2){
            return true;
        }
        double x = coordinates[1][0]-coordinates[0][0];
        double y = coordinates[1][1]-coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            if(x == 0 && (coordinates[i][0] - coordinates[i-1][0] != 0)){
                return false;
            }else if(y == 0 && (coordinates[i][1] - coordinates[i-1][1] != 0)){
                return false;
            }else if(x != 0 && y != 0 && (((coordinates[i][1]-coordinates[i-1][1]) == 0) || ((new Double((coordinates[i][0]-coordinates[i-1][0]))/new Double((coordinates[i][1]-coordinates[i-1][1]))) != (x/y)))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] coordinates = new int[][]{{0,1},{1,3},{-4,-7},{5,11}};
        System.out.println(""+checkStraightLine(coordinates));
    }

}
