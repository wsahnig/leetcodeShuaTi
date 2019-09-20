import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if(root == null) return sum;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            if(t.left != null){
                q.offer(t.left);
                t.left.val += t.val * 10; 
            }
            if(t.right != null){
                q.offer(t.right);
                t.right.val += t.val * 10;
            }
            if(t.left == null && t.right == null){
                sum += t.val;
            }
        }
        return sum; 
    }
}

