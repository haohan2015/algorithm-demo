package com.algorithm;

/**
 * @author admin
 * @Description: 最近的二分搜索树的值
 * @date 2019/12/11 20:58
 * 这道题让我们找一个二分搜索数的跟给定值最接近的一个节点值
 */
public class ClosestBinarySearchTreeValue {

    public static int closestValue(TreeNode root,int target){
        int difference = root.val;
        TreeNode next = root;
        while (next != null){
            int n = (next.val > target)?(next.val - target):(target - next.val);
            if(n < ((difference > target)?(difference - target):(target - difference))){
                difference = next.val;
            }
            if(difference == target){
                return difference;
            }

            if(next.val > target){
                next = next.left;
            }else{
                next = next.right;
            }
        }
        return difference;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(8);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        System.out.println("args = [" + closestValue(treeNode,7) + "]");
    }
}
