
/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack();
        TreeNode p = root, r = null;
        while(!st.isEmpty() || p!=null){
            while(p != null){
                st.push(p);
                p = p.left;
            }
            p = st.peek();
            if(p.right != null && p.right != r){
                p = p.right;
            }else{
                st.pop();
                ans.add(p.val);
                r = p;
                p = null;
            }
        }
        return ans;
    }
}

