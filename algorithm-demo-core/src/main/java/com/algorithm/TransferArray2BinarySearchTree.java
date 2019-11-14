package com.algorithm;

/**
 * @author admin
 * @Description: 将有序数组转换为二叉搜索树
 * @date 2019/10/29 19:23
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

0
/ \
-3   9
/   /
-10  5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TransferArray2BinarySearchTree {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }

        int length = nums.length;
        if(nums.length == 1){
            return new TreeNode(nums[0]);
        }

        int index1 = (length + 1) /2;
        TreeNode currentTreeNode = new TreeNode(nums[index1 - 1]);
        int[] leftNums = new int[index1 - 1];
        int[] rightNums = new int[length - index1];
        for (int i = 0; i < length; i++) {
            if(i < index1 - 1){
                leftNums[i] = nums[i];
            }else if(i > index1 - 1){
                rightNums[i - index1] = nums[i];
            }
        }
        currentTreeNode.left = sortedArrayToBST(leftNums);
        currentTreeNode.right = sortedArrayToBST(rightNums);
        return currentTreeNode;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(nums);
    }

}
