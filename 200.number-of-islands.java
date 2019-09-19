<<<<<<< HEAD
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

=======
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

>>>>>>> a47453625bbbdf482e37c42ed676631540a140d0
