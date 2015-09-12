package cn.edu.seu.leetcode;

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null==root) return null;
        while(true){
            if((root.val-p.val) * (root.val-q.val) <=0) return root;
            if(root.val < p.val){
                root = root.right;
            }else{
                root = root.left;
            }
        }
    }
}
