/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (39.87%)
 * Total Accepted:    206.4K
 * Total Submissions: 517.8K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
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
    public TreeNode buildTree(int[] preorder, int[] inorder,int s1,int e1,int s2,int e2){
        TreeNode root = new TreeNode(preorder[s1]);
        int rootIndex = 0;
       for(int i=s2;i<=e2;i++){
          if(inorder[i] == preorder[s1]){
              rootIndex = i;
              break;
          }
       }
       if(rootIndex != s2){
          root.left = buildTree(preorder,inorder,s1+1,s1+rootIndex-s2,s2,rootIndex - 1);
       }
       else root.left = null;

       if(rootIndex != e2){
           root.right = buildTree(preorder,inorder,s1+rootIndex-s2+1,e1,rootIndex+1,e2);
       }
       else root.right = null;

       return root;
    }
    

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len1 = preorder.length, len2 = inorder.length;
        if(len1 == 0) return null;
        return buildTree(preorder,inorder,0,len1-1,0,len2-1);
    }
}

