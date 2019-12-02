package com.algorithm;

/**
 * @author admin
 * @Description: 翻转二叉树
 * @date 2019/12/2 19:05
 * 翻转一棵二叉树。

示例：

输入：

4
/   \
2     7
/ \   / \
1   3 6   9
输出：

4
/   \
7     2
/ \   / \
9   6 3   1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/invert-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OverturnBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if(root == null || (root.right == null && root.left == null)){
            return root;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
