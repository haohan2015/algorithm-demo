package com.algorithm;

import java.util.*;

/**
 * @author admin
 * @Description: 二叉搜索树的最近公共祖先
 * @date 2019/12/4 17:37
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 

示例 1:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6
解释: 节点 2 和节点 8 的最近公共祖先是 6。
示例 2:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 

说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉搜索树中。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinarySearchTreeLowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || (root.right == null && root.left == null)){
            return root;
        }

        List<TreeNode> pPath = searchTreeNode(root,p);
        List<TreeNode> qPath = searchTreeNode(root,q);

        int i = 0;
        TreeNode lastSameNode = root;
        while (i < pPath.size() && i < qPath.size()){
            if(pPath.get(i).val == qPath.get(i).val){
                lastSameNode = pPath.get(i);
            }else{
                return lastSameNode;
            }
            i++;
        }

        return lastSameNode;

    }

    private static List<TreeNode> searchTreeNode(TreeNode root, TreeNode p){
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        if(root.val == p.val){
            treeNodes.add(root);
            return treeNodes;
        }

        List<TreeNode> leftPath = new ArrayList<TreeNode>();
        if(root.left != null){
            leftPath.addAll(searchTreeNode(root.left,p));
        }

        if(leftPath.size() > 0){
            List<TreeNode> newLeftPath = new ArrayList<TreeNode>();
            newLeftPath.add(root);
            newLeftPath.addAll(leftPath);
            return newLeftPath;
        }

        List<TreeNode> rightPath = new ArrayList<TreeNode>();
        if(root.right != null){
            rightPath.addAll(searchTreeNode(root.right,p));
        }

        if(rightPath.size() > 0){
            List<TreeNode> newRightPath = new ArrayList<TreeNode>();
            newRightPath.add(root);
            newRightPath.addAll(rightPath);
            return newRightPath;
        }

        return treeNodes;
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        System.out.println("args = [" + lowestCommonAncestor(treeNode,treeNode2,treeNode3) + "]");

    }

}
