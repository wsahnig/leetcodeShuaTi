/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */
class Solution {
    void dfsTracking(char[][] grid,int i,int j){
       if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j]=='1'){
           grid[i][j] = '0';
           dfsTracking(grid, i+1, j);
           dfsTracking(grid, i-1, j);
           dfsTracking(grid, i, j+1);
           dfsTracking(grid, i, j-1);
       }
    }
    public int numIslands(char[][] grid) {
        int cnt = 0;
        if(grid == null) return cnt;
        int m = grid.length;
        if(m == 0) return cnt;
        int n = grid[0].length;
        if(n == 0) return cnt;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    dfsTracking(grid,i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

