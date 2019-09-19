/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (38.30%)
 * Total Accepted:    144.2K
 * Total Submissions: 376.4K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree (int[] inorder, int[] postorder,int s1,int e1,int s2,int e2){
        TreeNode root = new TreeNode(postorder[e2]);
        int rootIndex = 0;
        for(int i=0;i <= e1;i++){
            if(inorder[i] == postorder[e2]){
                rootIndex = i;
                break;
            }
        }
        if(rootIndex != s1){
            root.left = buildTree(inorder,postorder,s1,rootIndex-1,s2,s2+rootIndex-s1-1);
        }
        else root.left = null;

        if(rootIndex != e1){
            root.right = buildTree(inorder,postorder,rootIndex+1,e1,s2+rootIndex-s1,e2-1);
        }
        else root.right = null;

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len1 = inorder.length, len2 = postorder.length;
        if(len1 == 0) return null;
        return buildTree(inorder,postorder,0,len1-1,0,len2-1);
    }
}

