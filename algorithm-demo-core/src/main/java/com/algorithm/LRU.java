package com.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author admin
 * @Description: TODO
 * @date 2020/9/2 15:07
 */
public class LRU {

    public static int[] LRU (int[][] operators, int k) {
        LinkedList<Integer> lruList = new LinkedList<Integer>();
        Map<Integer,Integer> lruMap = new HashMap<Integer,Integer>(k);
        int[] result = new int[operators.length];
        int j = 0;
        for(int i = 0;i < operators.length;i++){
            int[] subArray = operators[i];
            if(subArray[0] == 1){
                if(lruMap.containsKey(subArray[1])){
                    lruList.removeFirstOccurrence(subArray[1]);
                    lruList.addFirst(subArray[1]);
                    lruMap.put(subArray[1],subArray[2]);
                }else{
                    lruList.addFirst(subArray[1]);
                    lruMap.put(subArray[1],subArray[2]);
                    if(lruMap.size()>k){
                        lruMap.remove(lruList.removeLast());
                    }
                }
            }else{
                if(lruMap.containsKey(subArray[1])){
                    lruList.removeFirstOccurrence(subArray[1]);
                    lruList.addFirst(subArray[1]);
                    result[j] = lruMap.get(subArray[1]);
                    j++;
                }else{
                    result[j] = -1;
                }
            }
        }

        return result;
    }
}
