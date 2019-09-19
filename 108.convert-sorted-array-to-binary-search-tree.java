/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * algorithms
 * Easy (49.56%)
 * Total Accepted:    244.1K
 * Total Submissions: 492.3K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * Example:
 * 
 * 
 * Given the sorted array: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following
 * height balanced BST:
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
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
    public TreeNode binaryInsert(int i,int j,int[] nums){
        if(i > j) return null;
        else if(i == j) return new TreeNode(nums[i]);
        else{
            int mid = (i + j) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = binaryInsert(i,mid-1,nums);
            node.right = binaryInsert(mid+1,j,nums);
            return node;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return binaryInsert(0,nums.length-1,nums);
    }
}

