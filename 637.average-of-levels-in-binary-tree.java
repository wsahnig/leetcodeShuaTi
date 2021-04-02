/*
 * @lc app=leetcode id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            double sum = 0;
            for(int i=0; i<size; i++)
            {
                TreeNode tNode = q.poll();
                sum += tNode.val;
                if(tNode.left != null)
                {
                    q.offer(tNode.left);
                }
                if(tNode.right != null)
                {
                    q.offer(tNode.right);
                }
            }
            ans.add(sum / size);
        }
        return ans;
    }
}
// @lc code=end

