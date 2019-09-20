/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
       if(root == null) return null;
       Queue<Node> q = new LinkedList<Node>();
       q.offer(root);
       while(!q.isEmpty()){
           int size = q.size();// num of node in this level
           Node pre = null;
           for(int i=0;i<size;i++){
                Node curr = q.poll();
                if(pre != null) pre.next=curr;//curr is the first node in this level
                pre = curr;
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }       
       }
       return root;
    }
}

