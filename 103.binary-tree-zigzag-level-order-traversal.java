/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (40.79%)
 * Total Accepted:    202K
 * Total Submissions: 495.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
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
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> curr = new LinkedList();
        Queue<TreeNode> next = new LinkedList();
        List<List<Integer>> ans = new ArrayList();
        List<Integer> list = new ArrayList();
        int num = 0;
        curr.offer(root);
        while(curr.peek() != null){
            TreeNode node = curr.poll();
            list.add(node.val);
            if(node.left != null) next.offer(node.left);
            if(node.right != null) next.offer(node.right);
            if(curr.peek() == null){
               num ++;
               curr = next;
               next = new LinkedList();
               if(num % 2 == 0) Collections.reverse(list);
               //System.out.println(num+" : "+list);
               ans.add(list);
               list = new ArrayList();
            }
        }
        return ans;
    }
}

