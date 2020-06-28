package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @Description: 二叉树的右视图
 * @date 2020/4/22 21:05
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

1            <---
/   \
2     3         <---
\     \
5     4       <---

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RightSideView {

/*    public List<Integer> rightSideViewTest(TreeNode root) {
        List<Integer> index = new ArrayList<>();


    }*/

    public static void get(TreeNode treeNode,List<Integer> treeList,int parentIndex,int left){
        int cIndex = 0;
        if(left == 1){
            cIndex = (parentIndex * 2 + 1);
        }else if(left == 2){
            cIndex = (parentIndex * 2 + 2);
        }
        treeList.add(cIndex,treeNode.val);
        if(treeNode.left != null){
            get(treeNode.left,treeList,cIndex,1);
        }

        if(treeNode.right != null){
            get(treeNode.right,treeList,cIndex,2);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        List<Integer> integers = new ArrayList<>(Integer.MAX_VALUE);
        get(treeNode1,integers,0,0);
        integers.forEach(i-> System.out.println("args = [" + i + "]"));
    }
}
