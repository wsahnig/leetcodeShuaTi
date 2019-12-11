/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (39.72%)
 * Total Accepted:    217.7K
 * Total Submissions: 548.2K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
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
    // public List<List<Integer>> ans = new ArrayList<List<Integer>>();
 
    // public void pathSum(TreeNode root, int sum,List<Integer> list){

    //     list.add(root.val);
    //     if(root.left == null && root.right == null && root.val == sum){
    //           ans.add(list);
    //     }        
    //     if(root.left != null){
    //         List<Integer> l = new ArrayList<Integer>();
    //         l.addAll(list);
    //         pathSum(root.left,sum - root.val,l);
    //     }
    //     if(root.right != null){
    //         List<Integer> r = new ArrayList<Integer>();
    //         r.addAll(list);
    //         pathSum(root.right,sum - root.val,r);
    //     }
    // }
    public void FindPath(TreeNode root,int curr,int target,List<Integer> list,List<List<Integer>> ans){
        if(root == null) return;
        curr += root.val;
        if(root.left == null && root.right == null){
            if(curr == target){
                 list.add(root.val);
                 ans.add(new ArrayList(list));
                 list.remove(list.size()-1);
            }
            return;
        }
        list.add(root.val);
        FindPath(root.left,curr,target,list,ans);
        FindPath(root.right,curr,target,list,ans);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root != null){
            List<Integer> list = new ArrayList();
            int curr = 0;
            FindPath(root,curr,sum,list,ans);
        }
        return ans;
    }

    // public List<List<Integer>> pathSum2(TreeNode root, int sum) {
    //     if(root != null){
    //     List<Integer> list = new ArrayList<Integer>();
    //     pathSum(root,sum,list);
    //     }
    //     return ans;
    // }
}

