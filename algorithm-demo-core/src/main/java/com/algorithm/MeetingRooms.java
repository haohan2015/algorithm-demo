package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @Description: 会议室
 * @date 2019/12/5 21:34
 * Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: [[7,10],[2,4]]
Output: true
这道题给了我们一堆会议的时间，问能不能同时参见所有的会议，这实际上就是求区间是否有交集的问题
 */
public class MeetingRooms {

    public static boolean canAttendMeetings(List<List<Integer>> meetings){
        for (int i = 0; i < meetings.size(); i++) {
            int first = meetings.get(i).get(0);
            int second = meetings.get(i).get(1);
            for (int j = 0; j < i; j++) {
                int first1 = meetings.get(j).get(0);
                int second1 = meetings.get(j).get(1);
                if(first >= first1 && first <= second1){
                    return false;
                }

                if(first1 > first && first1 < second){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> meetings = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(30);
        meetings.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(10);
        meetings.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(15);
        list3.add(20);
        meetings.add(list3);
        System.out.println("args = [" + canAttendMeetings(meetings) + "]");
    }

}
