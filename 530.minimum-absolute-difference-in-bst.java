/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
 */

// @lc code=start
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
    private void PostOrder(TreeNode root,List<Integer> list){
        if(root == null) return;

        PostOrder(root.left,list);
        list.add(root.val);
        PostOrder(root.right,list);
    }


    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList();
        PostOrder(root,list);
        
        int min = Integer.MAX_VALUE;
        for(int i=1; i<list.size(); i++){
             int x = list.get(i-1);
             int y = list.get(i);
             min = Math.min(min,y-x);
        }
        return min;
    }
}
// @lc code=end

