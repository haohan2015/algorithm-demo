package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @Description: Flip Game 翻转游戏
 * @date 2019/12/17 19:14

这道题让我们把相邻的两个++变成--

 */
public class FlipGame {

    public static List<String> generatePossibleNextMoves(String str){
        List<String> strings = new ArrayList<>();
        if(str == null || str.length() == 0){
            return strings;
        }

        for (int i = 1; i < str.length(); i++) {
            if(String.valueOf(str.charAt(i)).equals("+") && String.valueOf(str.charAt(i-1)).equals("+")){
                strings.add(str.substring(0,i-1)+"--"+str.substring(i+1,str.length()));
            }
        }

        return strings;
    }

    public static void main(String[] args) {
        List<String> strings = generatePossibleNextMoves("++++");
        strings.forEach(i-> System.out.println("args = [" + i + "]"));
    }

}
