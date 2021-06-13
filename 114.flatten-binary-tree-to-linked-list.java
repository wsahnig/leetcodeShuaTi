import java.util.Stack;

/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (41.42%)
 * Total Accepted:    225K
 * Total Submissions: 542.7K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   5
 * ⁠/ \   \
 * 3   4   6
 * 
 * 
 * The flattened tree should look like:
 * 
 * 
 * 1
 * ⁠\
 * ⁠ 2
 * ⁠  \
 * ⁠   3
 * ⁠    \
 * ⁠     4
 * ⁠      \
 * ⁠       5
 * ⁠        \
 * ⁠         6
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
    public void flatten2(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> st = new Stack();
        
        while(p != null){
                     
            if(p.left != null){
                if(p.right != null) st.push(p.right);
                p.right = p.left;
                p.left = null;
            }
            
                                       
            if(p.right == null && !st.isEmpty()){
                    p.right = st.pop();
                    
               }
        
               p = p.right; 
                               
        } 
    }
    public void flatten(TreeNode root) {
        while(root != null)
        {
            if(root.left != null)
            {
                TreeNode prev = root.left;
                while(prev.right != null)
                {
                    prev = prev.right;
                }
                prev.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
     }
}

