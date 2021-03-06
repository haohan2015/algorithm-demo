package com.algorithm;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author admin
 * @Description: LRU缓存机制
 * @date 2020/5/25 20:30
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

/*获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

 

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？

 

示例:

LRUCache cache = new LRUCache( 2 *//* 缓存容量 *//* )*/

/*        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4*/
public class LRUCache {

    private Integer capacity;

    private TreeMap<Key,Integer> treeMap;

    public LRUCache(int capacity) {
        this.treeMap = new TreeMap<Key,Integer>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Key key1 = new Key(key);
        int val = treeMap.getOrDefault(key1,-1);
        if(val != -1){
            treeMap.put(key1,val);
        }
        return val;
    }

    public void put(int key, int value) {
        if(treeMap.size() >= capacity){
            for (int i = 0; i <= treeMap.size() - capacity; i++) {
                Key key1 = treeMap.lastKey();
                treeMap.remove(key1);
            }
        }
        Key key1 = new Key(key);
        treeMap.put(key1,value);
    }

    class Key implements Comparable{

        private int key;

        private long time;

        public Key(int key) {
            this.key = key;
            this.time = System.currentTimeMillis();
        }

        public int getKey() {
            this.time = System.currentTimeMillis();
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        @Override
        public int compareTo(Object o) {
            return this.time > ((Key)o).time ? 1:(this.time == ((Key)o).time?0:-1);
        }

        @Override
        public boolean equals(Object obj) {
            return this.key == ((Key)obj).key;
        }
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println("args = [" + lruCache.get(1) + "]");
        lruCache.put(3, 3);
        System.out.println("args = [" + lruCache.get(2) + "]");

    }

}
