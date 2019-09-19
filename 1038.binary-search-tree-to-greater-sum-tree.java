/*
 * @lc app=leetcode id=1038 lang=java
 *
 * [1038] Binary Search Tree to Greater Sum Tree
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
    private int sumOfNodeValue(TreeNode root){
        if(root != null){
            int sum = root.val;
            sum += sumOfNodeValue(root.left);
            sum += sumOfNodeValue(root.right);
            return sum;
        }
        return 0;
    }
    public TreeNode bstToGst(TreeNode root) {
        if(root == null) return root;
        Stack<TreeNode> st = new Stack();
        TreeNode p = root;
        int pre = 0;
        int sum = sumOfNodeValue(root);
        System.out.println(sum);
        while(!st.isEmpty() || p != null){
            while(p != null){
                st.push(p);
                p = p.left;
            }
            p = st.pop();
            int tmp = p.val;
            p.val = sum - pre;
            pre += tmp;
            
            p = p.right;
        }
        return root;
    }
}

