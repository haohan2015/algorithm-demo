package com.algorithm;

/**
 * @author admin
 * @Description:  二叉树的最大深度
 * @date 2019/10/17 20:10
 *
 *给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

3
/ \
9  20
/  \
15   7
返回它的最大深度 3 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class MaxDepthTree {

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.right == null && root.left == null){
            return 1;
        }
        int leftDepth = maxDepth(root.left)+1;
        int rightDepth = maxDepth(root.right)+1;
        return leftDepth>=rightDepth?leftDepth:rightDepth;
    }

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(3);
        TreeNode p2 = new TreeNode(9);
        TreeNode p3 = new TreeNode(20);
        p1.left = p2;
        p1.right = p3;

        TreeNode p4 = new TreeNode(15);
        TreeNode p5 = new TreeNode(7);
        p3.left = p4;
        p3.right = p5;
        System.out.println("args = [" + maxDepth(p1) + "]");
    }

}
