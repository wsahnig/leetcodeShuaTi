/*
 * @lc app=leetcode id=1302 lang=java
 *
 * [1302] Deepest Leaves Sum
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
    private int depth(TreeNode root)
    {
        if(root == null) return 0;
        return 1+Math.max(depth(root.left), depth(root.right));
    }
    
    private int count(TreeNode root, int curDep, int depth)
    {
        if(root == null) return 0;
        
        if(curDep == depth)
        {
            return root.val;
        }
        return count(root.left, curDep+1, depth) + count(root.right, curDep+1, depth);
    }
    
    public int deepestLeavesSum(TreeNode root) {
        int dep = depth(root);
        
        return count(root, 1, dep);
        
    }
}
// @lc code=end

