/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
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
class BSTIterator {
    
    Stack<TreeNode> st = new Stack();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }
    
    /** @return the next smallest number */
    public int next() {
       TreeNode t = st.pop();
       pushLeft(t.right);
       return t.val; 
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
       return !st.isEmpty(); 
    }

    public void pushLeft(TreeNode t){
        while(t != null){
            st.push(t);
            t = t.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

