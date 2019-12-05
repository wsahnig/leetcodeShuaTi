/*
 * @lc app=leetcode id=685 lang=java
 *
 * [685] Redundant Connection II
 */

// @lc code=start
class Solution {
    private int find(int[] parent,int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        for(int i=0;i<parent.length;i++)
           parent[i] = i;
        int[] ans1 = null, ans2 = null;
        for(int[] e : edges){
            int root0 = find(parent,e[0]), root1 = find(parent,e[1]);
            if(root1 != e[1]) ans1 = e;
            else if(root0 == e[1]) ans2 = e;
            else parent[e[1]] = e[0];
        }
        if(ans1 == null) return ans2;
        if(ans2 == null) return ans1;
        for(int[] e:edges){
            if(e[1] == ans1[1]) return e;
        }
        return new int[2];
    }
}
// @lc code=end

