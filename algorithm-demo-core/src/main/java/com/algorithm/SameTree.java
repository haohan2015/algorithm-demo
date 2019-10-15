package com.algorithm;

/**
 * @author admin
 * @Description: 相同的树
 * @date 2019/9/26 20:54
 * 给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例 1:

输入:       1         1
/ \       / \
2   3     2   3

[1,2,3],   [1,2,3]

输出: true
示例 2:

输入:      1          1
/           \
2             2

[1,2],     [1,null,2]

输出: false
示例 3:

输入:       1         1
/ \       / \
2   1     1   2

[1,2,1],   [1,1,2]

输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/same-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        System.out.println("p = [" + traverseTree(p) + "], q = [" + traverseTree(q) + "]");
        return traverseTree(p).equals(traverseTree(q));
    }


    public static String traverseTree(TreeNode p){
        StringBuilder stringBuilder = new StringBuilder();
        if(p ==null){
            return stringBuilder.toString();
        }

        if(p.left == null && p.right == null){
            stringBuilder.append(p.val);
            return stringBuilder.toString();
        }

        if(p.left != null){
            stringBuilder.append(traverseTree(p.left));
        }else{
            stringBuilder.append("null");
        }

        stringBuilder.append(p.val);
        if(p.right != null){
            stringBuilder.append(traverseTree(p.right));
        }else{
            stringBuilder.append("null");
        }
        return stringBuilder.toString();
    }

    public static boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p == null && q== null){
            return true;
        }else if(p != null && q != null && p.val == q.val){
            return isSameTree1(p.left,q.left) && isSameTree1(p.right,q.right);
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        TreeNode p1 = new TreeNode(4);
        TreeNode p2 = new TreeNode(1);
        p1.right = p2;
        TreeNode p3 = new TreeNode(2);
        p2.left = p3;

        TreeNode q1 = new TreeNode(1);
        TreeNode q2 = new TreeNode(4);
        q1.left = q2;
        TreeNode q3 = new TreeNode(2);
        q2.right = q3;

        System.out.println("args = [" + isSameTree1(p1,q1) + "]");

    }


}
