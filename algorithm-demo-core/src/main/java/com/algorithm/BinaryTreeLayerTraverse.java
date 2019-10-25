package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @Description: 二叉树的层次遍历
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

3
/ \
9  20
/  \
15   7
返回其自底向上的层次遍历为：

[
[15,7],
[9,20],
[3]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2019/10/25 18:31
 */
public class BinaryTreeLayerTraverse {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }

        if(root.right == null && root.left == null){
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            List<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            lists.add(list);
            return lists;
        }

        List<List<Integer>> leftLists = new ArrayList<List<Integer>>();
        if(root.left != null){
            leftLists = levelOrderBottom(root.left);
        }

        List<List<Integer>> rightLists = new ArrayList<List<Integer>>();
        if(root.right != null){
            rightLists = levelOrderBottom(root.right);
        }

        int maxLength = rightLists.size() > leftLists.size()?rightLists.size():leftLists.size();
        int leftDifferenceLength = maxLength - leftLists.size();
        int rightDifferenceLength = maxLength - rightLists.size();
        List<List<Integer>> finalLists = new ArrayList<List<Integer>>();
        for (int i = 1; i <= maxLength; i++) {
            List<Integer> leftList = (i > leftDifferenceLength)?leftLists.get(i - leftDifferenceLength - 1):new ArrayList<Integer>();
            List<Integer> rightList = (i > rightDifferenceLength)?rightLists.get(i - rightDifferenceLength - 1):new ArrayList<Integer>();
            leftList.addAll(rightList);
            finalLists.add(leftList);
        }

        List<Integer> currentNode = new ArrayList<Integer>();
        currentNode.add(root.val);
        finalLists.add(currentNode);
        return finalLists;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        treeNode1.left = treeNode2;
/*        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;*/
        for (List<Integer> list:levelOrderBottom(treeNode1)) {
            System.out.println("[");
            for (Integer i:list) {
                System.out.println(i);
                System.out.println(",");
            }
            System.out.println("]");
        }
    }

}
