/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftcnt = 0,rightcnt = 0;
        TreeNode t = root;
        while(t != null){
            leftcnt ++;
            t = t.left;
        }
        t = root;
        while(t != null){
            rightcnt ++;
            t = t.right;
        }
        if(leftcnt == rightcnt) 
           return (1 << leftcnt) - 1;
        else
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

