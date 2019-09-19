/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }
    int index = -1,len;
    String[] s;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index++;
        if(index == 0){
             s = data.split(",");
             len = s.length;
        }
        if(index >= len) return null;
        TreeNode root = null;
        if(!s[index].equals("#")){
            root = new TreeNode(Integer.parseInt(s[index]));
            root.left = deserialize(data);
            root.right = deserialize(data);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

