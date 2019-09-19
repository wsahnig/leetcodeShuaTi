/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (45.88%)
 * Total Accepted:    213.3K
 * Total Submissions: 464.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the bottom-up level order traversal of its
 * nodes' values. (ie, from left to right, level by level from leaf to root).
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
 * return its bottom-up level order traversal as:
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
               ans.add(0,list);
               list = new ArrayList();
            }
        }
        return ans;
    }
}

