/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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
    public List<String> binaryTreePaths(TreeNode root) {
       Stack<TreeNode> st = new Stack();
       List<String> ans = new ArrayList();
       List<TreeNode> list = new ArrayList();
       TreeNode p = root;
       while(p != null || !st.isEmpty()){
            while(p != null){
                list.add(p);
                st.push(p);
                p = p.left;
                
            }
            p = st.pop();
            while(p != list.get(list.size()-1)){
                 list.remove(list.size()-1);
            }
            if(p.right == null && p.left == null){
                String s="";
                int i = 0;
                for(i = 0;i<list.size()-1;i++){
                    s = s+list.get(i).val+"->";
                }
                s+=list.get(i).val;
                ans.add(s);
            }
            p = p.right;            
       }
       return ans;
    }
}

