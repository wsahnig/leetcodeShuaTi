/*
 * @lc app=leetcode id=1123 lang=java
 *
 * [1123] Lowest Common Ancestor of Deepest Leaves
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
    public TreeNode lcaDeepestLeaves(TreeNode root) 
    {
        if(root == null) return root;
        int left = depth(root.left);
        int right = depth(root.right);
        if(left == right)
        {
            return root;
        }
        else if(left < right)
        {
            return lcaDeepestLeaves(root.right);
        }
        else
        {
            return lcaDeepestLeaves(root.left);
        }
    }
    private int depth(TreeNode root)
    {
        if(root == null) return 0;
        return 1+Math.max(depth(root.left),depth(root.right));
    }
}
// @lc code=end

