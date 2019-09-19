/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    // int res = 0,cnt = 0;
    
    // private void inOrder(TreeNode root){
    //     if(root != null){
    //         inOrder(root.left);
            
            
    //         System.out.println(root.val +":" +cnt);
    //         if(--cnt == 0 ) {
    //             res = root.val;
    //         }

    //         inOrder(root.right);       
    //     }
    // }
    public int kthSmallest(TreeNode root, int k) {
        // cnt = k;
        // inOrder(root);
        Stack<TreeNode> st = new Stack();
        TreeNode t = root;
        while(!st.isEmpty() || t != null){
            while(t!=null){
                st.push(t);
                t = t.left;
            }
            t = st.pop();
            if(--k == 0){
                return t.val;
            }
            t = t.right;
        }    
        return 0;
    }
}

