/*
 * @lc app=leetcode id=865 lang=java
 *
 * [865] Smallest Subtree with all the Deepest Nodes
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null)
        return root;
    
        int left = height(root.left);
        int right = height(root.right);
        
        if(left == right)
            return root;
        else if(left < right)
            return subtreeWithAllDeepest(root.right);
        else
            return subtreeWithAllDeepest(root.left);
    }
    private int height(TreeNode root){
        if(root == null)
            return 0;
        
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
// @lc code=end

