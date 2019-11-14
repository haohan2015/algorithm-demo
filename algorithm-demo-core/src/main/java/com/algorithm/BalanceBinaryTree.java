package com.algorithm;

/**
 * @author admin
 * @Description: 平衡二叉树
 * @date 2019/11/7 19:05
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

3
/ \
9  20
/  \
15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

1
/ \
2   2
/ \
3   3
/ \
4   4
返回 false 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/balanced-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class BalanceBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        if(root.left == null && root.right == null){
           return true;
        }

        boolean leftIsBananced = isBalanced(root.left);
        if(!leftIsBananced){
            return false;
        }
        boolean rightIsBananced = isBalanced(root.right);
        if(!rightIsBananced){
            return false;
        }

        int leftTreeDepth = getDepth(root.left);
        int rightTreeDepth = getDepth(root.right);
        int sum = leftTreeDepth - rightTreeDepth;
        if(sum == 1 || sum == -1 || sum == 0){
            return true;
        }

        return false;
    }

    public static int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        int leftTreeDepth = getDepth(root.left);
        int rightTreeDepth = getDepth(root.right);
        if(leftTreeDepth > rightTreeDepth){
            return leftTreeDepth + 1;
        }
        return rightTreeDepth + 1;
    }

    public static void main(String[] args) {

        TreeNode p1 = new TreeNode(1);
        TreeNode p21 = new TreeNode(1);
        TreeNode p22 = new TreeNode(1);
        p1.left = p21;
        p1.right = p22;

        TreeNode p31 = new TreeNode(1);
        TreeNode p32 = new TreeNode(1);
        p21.left = p31;
        p21.right = p32;

        TreeNode p41 = new TreeNode(1);
        TreeNode p42 = new TreeNode(1);
        p31.left = p41;
        p31.right = p42;

        System.out.println("args = [" + isBalanced(p1) + "]");

    }

}
