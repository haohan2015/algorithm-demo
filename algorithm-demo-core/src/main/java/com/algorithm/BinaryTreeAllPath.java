package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @Description:  二叉树的所有路径
 * @date 2019/12/10 18:50
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

1
/   \
2     3
\
5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeAllPath {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> strings = new ArrayList<>();
        if(root == null){
            return strings;
        }

        if(root.left != null){
            strings.addAll(binaryTreePaths(root.left));
        }

        if(root.right != null){
            strings.addAll(binaryTreePaths(root.right));
        }

        if(root.left == null && root.right == null){
            strings.add(root.val+"");
            return strings;
        }

        for (int i = 0; i < strings.size(); i++) {
            strings.set(i,root.val + "->" +strings.get(i));
        }

        return strings;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(5);
        treeNode2.right = treeNode4;
        binaryTreePaths(treeNode).forEach(i-> System.out.println("args = [" + i + "]"));

    }
}
