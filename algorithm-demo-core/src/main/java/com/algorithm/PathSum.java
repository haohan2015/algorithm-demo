package com.algorithm;

/**
 * @author admin
 * @Description: 路径之和
 * @date 2019/11/14 17:33
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例: 
给定如下二叉树，以及目标和 sum = 22，

5
/ \
4   8
/   / \
11  13  4
/  \      \
7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *[-2,null,-3]
-5
 *
 */
public class PathSum {

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null && root.val == sum){
            return true;
        }

        return (hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val));
    }

    public static void main(String[] args) {

        TreeNode p1 = new TreeNode(5);
        TreeNode p21 = new TreeNode(4);
        TreeNode p22 = new TreeNode(8);
        p1.left = p21;
        p1.right = p22;
        TreeNode p31 = new TreeNode(11);
        p21.left = p31;
        TreeNode p33 = new TreeNode(13);
        TreeNode p34 = new TreeNode(4);
        p22.left = p33;
        p22.right = p34;

        TreeNode p41 = new TreeNode(7);
        TreeNode p42 = new TreeNode(2);
        p31.left = p41;
        p31.right = p42;

        TreeNode p43 = new TreeNode(1);
        p34.right = p43;

        System.out.println("args = [" + hasPathSum(p1,22) + "]");





    }

}
