/*
 * @lc app=leetcode id=589 lang=java
 *
 * [589] N-ary Tree Preorder Traversal
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private void dfs(Node root,List<Integer> order)
    {
        if(root == null) return;
        List<Node> children = root.children;
        order.add(root.val);
        for(int i=0; i<children.size(); i++)
        {
            dfs(children.get(i), order);
        }
    }
    public List<Integer> preorder2(Node root) {
        List<Integer> preOrder = new ArrayList<>();
        dfs(root, preOrder);
        return preOrder;
    }
    
    public List<Integer> preorder(Node root) {
        Stack<Node> st = new Stack<>();
        st.push(root);
        List<Integer> preOrder = new ArrayList<>();
        if(root == null) return preOrder;
        preOrder.add(root.val);
        while(!st.isEmpty())
        {
            Node t = st.peek();
            if(t.children == null || t.children.size() == 0) st.pop();
            else{
                Node child = t.children.get(0);
                st.push(child);
                preOrder.add(child.val);
                t.children.remove(0);
            }
        }
        return preOrder;
    }
}
// @lc code=end

