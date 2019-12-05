package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @Description: 最短单词距离
 * @date 2019/12/5 20:13
 * For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.
 */
public class ShortestWordDistance {

    public static int shortestDistance(String[] words,String word1,String word2){

        List<Integer> word1Index = new ArrayList<>();
        List<Integer> word2Index = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if(word1.equals(words[i])){
                word1Index.add(i);
            }else if(word2.equals(words[i])){
                word2Index.add(i);
            }
        }

        Integer distance = Integer.MAX_VALUE;
        for (Integer i:word1Index) {
            for (Integer j:word2Index) {
                int newDistance = (i < j)?(j -i):(i - j);
                if(newDistance < distance){
                    distance = newDistance;
                }
            }
        }

        return distance;
    }

    //只需要找到紧挨着word1的word2的最小距离
    public static int shortestDistance1(String[] words,String word1,String word2){

        Integer word1Index = null;
        Integer word2Index = null;
        Integer distance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if(word1.equals(words[i])){
                word1Index  = i;
            }else if(word2.equals(words[i])){
                word2Index  = i;
            }

            if(word1Index != null && word2Index != null){
                int newDistance = (word1Index < word2Index)?(word2Index -word1Index):(word1Index - word2Index);
                if(newDistance < distance){
                    distance = newDistance;
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println("args = [" + shortestDistance1(new String[]{"practice", "makes", "perfect", "coding", "makes"},"makes","coding") + "]");
    }

}
