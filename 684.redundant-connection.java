/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
    private int[] parent;
    private byte[] rank;

    private boolean union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return false;
        if      (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        return true;
    }

    private int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] reCon = new int[2];
        if(edges == null || edges.length == 0) return reCon;
        int n = edges.length;  
        parent = new int[n+1];
        rank = new byte[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for(int i = 0;i < n;i++){
            int p = edges[i][0];
            int q = edges[i][1];
            if(!union(p, q)){
                reCon[0] = p;
                reCon[1] = q;
                return reCon;
            }
        }
        return reCon;
    }
}
// @lc code=end

