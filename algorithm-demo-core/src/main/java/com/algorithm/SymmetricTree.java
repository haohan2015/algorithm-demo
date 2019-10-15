package com.algorithm;

/**
 * @author admin
 * @Description: 对称二叉树
 * @date 2019/10/15 18:05
 * 给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
3241423  3241423

1
/ \
2   2
/ \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
null231null23 32null132null
1
/ \
2   2
\   \
3    3

                5
            /       |
            4       1

[5,4,1,null,1,null,4,2,null,2,null]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/symmetric-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {

        if(root == null){
            return true;
        }

        if(root.left != null && root.right == null){
            return false;
        }

        if(root.right != null && root.left == null){
            return false;
        }

        return isSameTree1(root.left,rotateTree(root.right));
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

    public static TreeNode rotateTree(TreeNode p){
        if(p == null){
            return p;
        }

        if(p.left == null && p.right == null){
            return p;
        }

        TreeNode tempP = p.left;
        p.left = rotateTree(p.right);
        p.right = rotateTree(tempP);
        return p;
    }

    public static void main(String[] args) {

        TreeNode p = new TreeNode(1);
        TreeNode p21 = new TreeNode(2);
        TreeNode p22 = new TreeNode(2);
        p.left = p21;
        p.right = p22;

        TreeNode p31 = new TreeNode(3);
        TreeNode p32 = new TreeNode(4);
        p21.left = p31;
        p21.right = p32;

        TreeNode p33 = new TreeNode(4);
        TreeNode p34 = new TreeNode(3);
        p22.left = p33;
        p22.right = p34;
        System.out.println("args = [" + isSymmetric(p) + "]");
    }

}
