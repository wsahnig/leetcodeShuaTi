/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node p = head;
        Node copy = new Node(p.val,new Node(),new Node());
        Node q = copy;
        HashMap<Integer,Node> hm = new HashMap();
        hm.put(copy.val,copy);
        while(p != null){
            if(p.next != null){
               Node n = new Node(p.next.val,new Node(),new Node());
               hm.put(n.val,n);
               q.next = n;
               q = q.next; 
            }
            p = p.next;            
        }
        q.next = null;
        p = head;
        q = copy;
        while(p != null){
            if(p.random != null){
                q.random = hm.get(p.random.val);
            }
            else q.random = null;
            p = p.next;
            q = q.next;
        }
        return copy;
    }
}

