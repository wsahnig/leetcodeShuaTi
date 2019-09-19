/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
      if(node == null) return node;
      Node clone= new Node(node.val,new ArrayList());
      Queue<Node> q = new LinkedList();
      Queue<Node> q2 = new LinkedList();
      HashMap<Integer,Node> hm = new HashMap();
      hm.put(node.val,clone);
      q.offer(node);
      q2.offer(clone);
      while(!q.isEmpty()){
          Node p = q.poll();
          Node p2 = q2.poll();         
          for(Node n : p.neighbors){
              if(!hm.containsKey(n.val)){
                  q.offer(n);
                  Node n2 = new Node(n.val,new LinkedList());//clone
                  hm.put(n.val,n2);//mark this new node in hm
                  p2.neighbors.add(n2);
                  q2.offer(n2);
              }else{
                  p2.neighbors.add(hm.get(n.val));
              }     
          }
      }
    return clone;
    }
}

