/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    public void recoverTree(TreeNode root) {
        TreeNode cur = root, prev = null,first = null ,second = null,p = null;
        while (cur != null)
        {
            if (cur.left != null) 
            {
                prev = cur.left;
                while (prev.right != null && prev.right != cur)
                    prev = prev.right;

                if (prev.right == null)   
                {
                    prev.right = cur;
                    cur = cur.left;
                    continue;
                }
                else                      
                {
                    prev.right = null;
                }
            }
            if(p != null && cur.val < p.val){
                if(first==null) first=p;
                second = cur;
            }
            p=cur;
            cur=cur.right;

        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
// @lc code=end

