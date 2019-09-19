/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (47.42%)
 * Total Accepted:    348.4K
 * Total Submissions: 734.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        Queue<TreeNode> next = new LinkedList();
        List<List<Integer>> ans = new ArrayList();
        List<Integer> list = new ArrayList();
        q.offer(root);
        while(q.peek() != null){
            TreeNode node = q.poll();
            list.add(node.val);
            if(node.left != null) next.offer(node.left);
            if(node.right != null) next.offer(node.right);
            if(q.peek() == null){
               q = next;
               next = new LinkedList();
               ans.add(list);
               list = new ArrayList();
            }
        }
        return ans;
    }
}

