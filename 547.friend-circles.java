/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */
class Solution {
    private void dfs(int[][] M,int[] vis,int i){
        for(int j=0;j<vis.length;j++){
            if(vis[j] == 0 && (M[i][j] == 1 || M[j][i] == 1)){
                vis[j] = 1;
                dfs(M,vis,j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int len = M.length;
        if(len == 0) return 0;
        int[] vis = new int[len];
        int cnt = 0;
        for(int i=0;i<len;i++){
            if(vis[i] == 0){
                vis[i] = 1;
                dfs(M,vis,i);
                cnt++; 
            }
        }
        return cnt;
    }
}

