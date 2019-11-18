package com.algorithm;


/**
 * @author admin
 * @Description: 最小栈
 * @date 2019/11/18 18:43
 *
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-stack
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {

    Node head;

    Node min;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(head == null){
            head = new Node(x);
            min = head;
        }else{
            Node node = new Node(x);
            head.last = node;
            node.nest = head;
            head = node;

            if(x < min.val){
                node.moreBig = min;
                min.moreSmall = node;
                min = node;
            }else{

                Node curNode = min;
                while (curNode.moreBig != null && x > curNode.moreBig.val){
                    curNode = curNode.moreBig;
                }

                if(curNode.moreBig == null){
                    curNode.moreBig = node;
                    node.moreSmall = curNode;
                }else{
                    node.moreBig = curNode.moreBig;
                    curNode.moreBig.moreSmall = node;
                    curNode.moreBig = node;
                    node.moreSmall = curNode;
                }

            }
        }
    }

    public void pop() {
        if(head != null){
            if(min == head){
                min = min.moreBig;
                if(min != null){
                    min.moreSmall = null;
                }
            }else{
                if(head.moreBig != null){
                    head.moreBig.moreSmall = head.moreSmall;
                }
                if(head.moreSmall != null){
                    head.moreSmall.moreBig = head.moreBig;
                }
            }

            head = head.nest;
            if(head != null){
                head.last = null;
            }
        }
    }

    public int top() {
        if(head != null){
            return head.val;
        }

        return 0;
    }

    public int getMin() {
        if(min != null){
            return min.val;
        }
        return 0;
    }

    class Node{

        int val;

        Node nest;

        Node last;

        Node moreBig;

        Node moreSmall;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        /**
         ["MinStack","push","push","push",,"pop",,"pop",,"pop","push","push",,"pop"]
         [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
         */

        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.push(2147483647);
        minStack.push(-2147483648);
        minStack.pop();
    }

}
