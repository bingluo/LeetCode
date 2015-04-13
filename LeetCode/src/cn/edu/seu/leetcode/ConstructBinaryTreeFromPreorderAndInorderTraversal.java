package cn.edu.seu.leetcode;

import java.util.HashMap;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        if(len==0)
            return null;
        for(int i=0;i<len;i++){
            inorderMap.put(inorder[i], i);
        }
        
        return findRoot(0, len-1, 0, preorder);
    }
    
    private TreeNode findRoot(int left, int right, int pIndex, int[] preorder){
        int val = preorder[pIndex];
        TreeNode p = new TreeNode(val);
        if(left<right){
            int lCount = inorderMap.get(val)-left;
            int rCount = right-inorderMap.get(val);
            p.left = lCount>0?findRoot(left,inorderMap.get(val)-1, pIndex+1, preorder):null;
            p.right = rCount>0?findRoot(inorderMap.get(val)+1, right, pIndex+lCount+1, preorder):null;
        }
        return p;
    }
}
