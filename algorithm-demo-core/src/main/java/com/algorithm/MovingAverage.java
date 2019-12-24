package com.algorithm;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author admin
 * @Description: 从数据流中移动平均值
 * @date 2019/12/24 20:27

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3


 */
public class MovingAverage {

    private int num;

    private Queue<Integer> queue;

    private double avg = 0;


    public MovingAverage(int num) {
        this.num = num;
        this.queue = new LinkedBlockingDeque<>(3);
    }

    public double next(int val){
        if(queue.size() < num){
            avg = (avg * queue.size() + val)/(queue.size() + 1);
            queue.offer(val);
        }else{
            avg = (avg * num - queue.poll() + val)/num;
            queue.offer(val);
        }
        return avg;
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println("args = [" + movingAverage.next(1) + "]");
        System.out.println("args = [" + movingAverage.next(10) + "]");
        System.out.println("args = [" + movingAverage.next(3) + "]");
        System.out.println("args = [" + movingAverage.next(5) + "]");
    }
}
