/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */
class Solution {
    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        int cnt = 0;
        n = grid.length;
        if(n == 0) return 0;
        m = grid[0].length;
        for(int i=0; i<n; i++){
           for(int j=0; j<m; j++){
            if(grid[i][j] == '1'){
                DFSMarking(grid,i,j);
                cnt++;
            }
           }
        }
        return cnt;
    }

    private void DFSMarking(char[][] grid, int i,int j){
      //unreachable
      if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') return;
      // the island is visited
      grid[i][j] = '0';
      DFSMarking(grid,i+1,j);
      DFSMarking(grid,i-1,j);
      DFSMarking(grid,i,j+1);
      DFSMarking(grid,i,j-1);
    }
}

