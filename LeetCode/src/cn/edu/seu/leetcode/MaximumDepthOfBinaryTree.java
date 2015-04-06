package cn.edu.seu.leetcode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return depth(root);
    }
    
    private int depth(TreeNode node){
        if(node==null)
            return 0;
        return 1+Math.max(depth(node.left),depth(node.right));
    }
}
