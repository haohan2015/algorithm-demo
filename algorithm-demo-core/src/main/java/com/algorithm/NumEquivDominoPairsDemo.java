package com.algorithm;

import java.util.*;

/**
 * @author admin
 * @Description: 等价多米诺骨牌对的数量
 * @date 2020/8/24 19:05
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 *  
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumEquivDominoPairsDemo {

    public static int numEquivDominoPairs(int[][] dominoes) {
        int num = 0;
        for (int i = 0; i < dominoes.length-1; i++) {
            for (int j = i+1; j < dominoes.length; j++) {
                if((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1])||(dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0])){
                    num++;
                }
            }
        }
        return num;
    }

    public static int numEquivDominoPairs1(int[][] dominoes) {
        int num = 0;
        Map<Integer, List<String>> integerListMap = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            int sum = dominoes[i][0] + dominoes[i][1];
            List<String> integers = integerListMap.get(sum);
            if(integers == null){
                integers = new ArrayList<>();
                integerListMap.put(sum,integers);
            }

            for (String str:integers) {
                String[] intergerStr = str.split(";");
                if((dominoes[i][0] == Integer.valueOf(intergerStr[0]) && dominoes[i][1] == Integer.valueOf(intergerStr[1]))
                 || (dominoes[i][0] == Integer.valueOf(intergerStr[1]) && dominoes[i][1] == Integer.valueOf(intergerStr[0]))){
                    num++;
                }
            }
            integers.add(dominoes[i][0] + ";" + dominoes[i][1]);
        }
        return num;
    }

    public static int numEquivDominoPairs3(int[][] dominoes) {
        int[][] total = new int[10][10];
        int sum = 0;
        for (int i = 0; i < dominoes.length; i++) {
            sum += total[dominoes[i][0]][dominoes[i][1]];
            if(dominoes[i][0] != dominoes[i][1]){
                sum += total[dominoes[i][1]][dominoes[i][0]];
            }
            total[dominoes[i][0]][dominoes[i][1]] += 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,1},{2,2},{1,1},{1,2},{1,2},{1,1}};
        System.out.println("args = " + numEquivDominoPairs3(nums));
    }
}
